package com.orion.java.homework9;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Downloader {

    volatile int commonSize = 0;

   private  HashMap<Integer,String>links;
   private CopyOnWriteArrayList<SiteText> siteTexts = new CopyOnWriteArrayList<>();


    public Downloader(List<String> links) {
        this.links = new HashMap<>();
        for (int i = 0; i < links.size(); i++) {
            this.links.put(i,links.get(i));
        }
    }
    public int getCommonSize() {
        return commonSize;
    }

    public CopyOnWriteArrayList<SiteText> getSiteTexts() {
        return siteTexts;
    }
    public void sequentialDownload() throws IOException {

        for (Map.Entry<Integer, String> entry : links.entrySet()) {
            try (InputStream in = new BufferedInputStream(new URL( entry.getValue()).openStream())) {
                synchronized (this) {
                    commonSize +=(new byte[in.available()]).length;
                }
                StringBuilder stringBuilder = new StringBuilder();
                while (in.read() != -1) {
                    stringBuilder.append((char) in.read());
                }
                siteTexts.add(new SiteText(new StringBuffer().append("==== НАЧАЛО САЙТА ").append( entry.getValue()).append(" ====")
                        .append(System.lineSeparator())
                        .append(stringBuilder).append("==== КОНЕЦ САЙТА ").append( entry.getValue()).append(" ====")
                        .append(System.lineSeparator()),entry.getKey()));
                in.close();
            }
        }
    }

    public void parallelDownload() throws IOException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for (Map.Entry<Integer, String> entry : links.entrySet()) {
            executorService.execute(() -> {
                try {
                    synchronized (this) {
                        try (InputStream in = new BufferedInputStream(new URL(entry.getValue()).openStream())) {
                            commonSize += (new byte[in.available()]).length;
                            StringBuilder stringBuilder = new StringBuilder();
                            while (in.read() != -1) {
                                stringBuilder.append((char) in.read());
                            }
                            siteTexts.add(new SiteText(new StringBuffer().append("==== НАЧАЛО САЙТА ").append(entry.getValue()).append(" ====")
                                    .append(System.lineSeparator())
                                    .append(stringBuilder).append("==== КОНЕЦ САЙТА ").append(entry.getValue()).append(" ====")
                                    .append(System.lineSeparator()),entry.getKey()));
                            in.close();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }



}
