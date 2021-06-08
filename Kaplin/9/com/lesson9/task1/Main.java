package com.lesson9.task1;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> links = List.of(
                "https://www.oracle.com/",
                "https://stackoverflow.com/",
                "https://vk.com/",
                "https://ru-ru.facebook.com/",
                "https://www.instagram.com/",
                "https://orioninc.zoom.us/",
                "https://ya.ru/",
                "https://google.com",
                "https://javarush.ru",
                "http://java-online.ru/",
                "https://www.oracle.com/",
                "https://nodejs.org/en/",
                "https://www.mongodb.com/try",
                "https://yandex.ru/dev/clickhouse/",
                "https://www.mysql.com/",
                "https://reactjs.org/",
                "https://redux.js.org/",
                "https://scikit-learn.org/stable/",
                "https://pandas.pydata.org/",
                "https://www.anaconda.com/");

        Downloader downloader = new Downloader(links);
        System.out.println("Последовательная загрузка");
        downloader.sequentialDownload("sequential.txt");
        System.out.println("Параллельная загрузка");
        downloader.parallelDownload("parallel.txt");

    }
}
