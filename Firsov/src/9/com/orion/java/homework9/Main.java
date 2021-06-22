package com.orion.java.homework9;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static String createDefaultFilePath(){
        String separator = File.separator;
        String filePath = System.getProperty("user.dir")
                + separator + "Firsov"
                + separator + "src"
                + separator + "9"
                + separator + "com"
                + separator + "orion"
                + separator + "files";
        return filePath;
    }
    public static void writeIntoFile(String filePath, Downloader downloader){
        Collections.sort(downloader.getSiteTexts());
        try(java.io.FileWriter writer = new java.io.FileWriter(filePath, false))
        {
            for (SiteText text : downloader.getSiteTexts()) {
                // запись всей строки
                writer.write(text.getData().toString());
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> links = new ArrayList<>();
        links.addAll(Arrays.asList(
                "https://www.google.ru/",
                "https://www.youtube.com/",
                "https://ru-ru.facebook.com/",
                "https://twitter.com/",
                "http://www.baidu.com/",
                "https://www.instagram.com/",
                "https://en.wikipedia.org/wiki/Main_Page/",
                "https://m.habr.com/ru/top/daily/",
                "https://fooobar.com/",
                "https://outlook.live.com/owa/",
                "https://www.ucnews.tk/",
                "https://mail.ru/",
                "https://www.uol.com.br/",
                "https://www.paypal.com/ru/home/",
                "https://www.roblox.com/",
                "https://www.rakuten.com/",
                "https://bitly.com/",
                "https://ria.ru/",
                "https://gosuslugi.ru/",
                "https://mk.ru/"
        ));
        links.sort(Comparator.naturalOrder());


        Downloader sequentialDownloader = new Downloader(links);
        long sequentialStart = System.nanoTime();
        sequentialDownloader.sequentialDownload();
        long sequentialFinish = System.nanoTime();
        System.out.println("Последовательная загрузка.Прошло времени, нс: " + (sequentialFinish - sequentialStart) + " Загруженные данные "+sequentialDownloader.getCommonSize());
        writeIntoFile(createDefaultFilePath()+"/sequential.txt",sequentialDownloader);

        Downloader parallelDownloader = new Downloader(links);
        long parallelStart = System.nanoTime();
        parallelDownloader.parallelDownload();
        long  parallelFinish = System.nanoTime();
        System.out.println("Параллельная загрузка.Прошло времени, нс: " + (parallelFinish - parallelStart) + " Загруженные данные "+parallelDownloader.getCommonSize());
        writeIntoFile(createDefaultFilePath()+"/parallel.txt",parallelDownloader);
    }
}
