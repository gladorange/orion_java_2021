package com.orion.java.hw9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class LinkDownloader {
    private List<String> links;

    public LinkDownloader(List<String> links) {
        this.links = links;
    }

    public void sequentialDownload(String filePath) {
        long startTime = System.currentTimeMillis();
        File file = new File(filePath);

        for (String link : links) {
            getWebsiteAndWriteInFile(file, link);
        }

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Последовательный вызов. Затраченное время: " + totalTime + ", размер файла: " + file.length());
    }

    public void parallelDownload(String filePath) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        File file = new File(filePath);

        ExecutorService executor = Executors.newFixedThreadPool(links.size(), r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        List<Future<?>> futures = new ArrayList<>();
        for (String link : links) {
            Future<?> submit = executor.submit(() -> {
                        getWebsiteAndWriteInFile(file, link);
                    }
            );
            futures.add(submit);
        }

        for (Future<?> future : futures) {
            future.get();
        }

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Параллельный вызов. Затраченное время: " + totalTime + ", размер файла: " + file.length());
    }

    private void getWebsiteAndWriteInFile(File file, String link) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== НАЧАЛО САЙТА <" + link + "> ======\n");
        URL website = null;
        try {
            website = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (InputStream inputStream = website.openStream()) {
            int read;
            while ((read = inputStream.read()) != -1) {
                sb.append(read);
            }
        } catch (IOException e) {
            sb.append("===== КОНЕЦ САЙТА <" + link + "> ======\n");
            e.printStackTrace();
        }
        sb.append("===== КОНЕЦ САЙТА <" + link + "> ======\n");

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
