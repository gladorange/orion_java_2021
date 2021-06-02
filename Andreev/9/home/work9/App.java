package home.work9;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class App {

    CopyOnWriteArrayList<Link> links;
    volatile int sumBytes = 0;
    CopyOnWriteArrayList<TextData> listInfo = new CopyOnWriteArrayList<>();

    public App() {
        this.links = getLinks();
    }

    public void doSequentialDownload() throws IOException {
        listInfo.clear();
        sumBytes=0;
        Long start = System.currentTimeMillis();
        downloadData();
        Long end = System.currentTimeMillis();
        System.out.println("Время загрузки: " + (end - start));
        System.out.println("Объем данных: " + sumBytes);
        writeToSequentialFile();

    }

    public void doParallelDownload() throws IOException, InterruptedException {
        listInfo.clear();
        sumBytes=0;
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Long start = System.currentTimeMillis();
        for (Link el : links) {
            executorService.execute(() -> {
                try {
                    downloadDataParallel(el);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        Long end = System.currentTimeMillis();
        System.out.println("Время загрузки: " + (end - start));
        System.out.println("Объем данных: " + sumBytes);
        writeToParallelFile();
    }

    private void downloadDataParallel(Link link) throws IOException {
        synchronized (this) {
            try (InputStream is = new BufferedInputStream(new URL(link.getLink()).openStream())) {
                System.out.println(Thread.currentThread().getName());
                sumBytes = sumBytes + getAllBytes(is);
                StringBuilder stringBuilder = new StringBuilder();
                while (is.read() != -1) {
                    stringBuilder.append((char) is.read());
                }
                listInfo.add(new TextData(new StringBuffer().append("==== НАЧАЛО САЙТА ").append(link.getLink()).append(" ====")
                        .append(System.lineSeparator())
                        .append(stringBuilder).append("==== КОНЕЦ САЙТА ").append(link.getLink()).append(" ====")
                        .append(System.lineSeparator()),link.getLinkNumber()));
            }
        }
    }

    private CopyOnWriteArrayList<Link> getLinks() {
        CopyOnWriteArrayList<Link> list = new CopyOnWriteArrayList<>();
        String link1 = "https://libking.ru/books/sf-/sf-fantasy/554026-";
        String link2 = "-andrey-koshchienko-odinokiy-demon-tetralogiya-si.html#book";
        for (int i = 1; i < 21; i++) {
            list.add(new Link((link1 + i + link2),i));
        }
        return list;
    }

    private void downloadData() throws IOException {
        for (Link el : links) {
            try (InputStream is = new BufferedInputStream(new URL(el.getLink()).openStream())) {
                System.out.println(Thread.currentThread().getName());
                synchronized (this) {
                    sumBytes = sumBytes + getAllBytes(is);
                }
                StringBuilder stringBuilder = new StringBuilder();
                while (is.read() != -1) {
                    stringBuilder.append((char) is.read());
                }
                listInfo.add(new TextData(new StringBuffer().append("==== НАЧАЛО САЙТА ").append(el.getLink()).append(" ====")
                        .append(System.lineSeparator())
                        .append(stringBuilder).append("==== КОНЕЦ САЙТА ").append(el.getLink()).append(" ====")
                        .append(System.lineSeparator()),el.getLinkNumber()));
            }
        }
    }

    private int getAllBytes(InputStream is) throws IOException {
        byte[] bytes = new byte[is.available()];
        return bytes.length;
    }

    private void writeToSequentialFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\1\\Documents\\sequential.txt")) {
            for (TextData el : listInfo) {
                fileWriter.write(el.getData().toString());
            }
        }
    }

    private void writeToParallelFile() throws IOException {
        Collections.sort(listInfo);
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\1\\Documents\\parallel.txt")) {
            for (TextData el : listInfo) {
                fileWriter.write(el.getData().toString());
            }
        }
    }
}
