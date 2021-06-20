package com.orion.java.hw9;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ExecutionException, InterruptedException {
        List<String> links = List.of(
                "https://www.google.ru/",
                "https://yandex.ru/",
                "https://www.yahoo.com/",
                "https://mail.ru/",
                "https://github.com/",
                "https://vk.com/",
                "https://www.instagram.com/",
                "https://ru-ru.facebook.com/",
                "https://twitter.com/?lang=ru",
                "https://www.youtube.com/",
                "https://music.youtube.com/",
                "https://www.e-katalog.ru/",
                "https://ru.wargaming.net/clans/wot/",
                "https://modxvm.com/ru/",
                "https://betacode.net/",
                "https://docs.oracle.com/en/",
                "http://proglang.su/",
                "https://career.orioninc.ru/",
                "http://www.unn.ru/"
        );

        LinkDownloader linkDownloader = new LinkDownloader(links);
        linkDownloader.sequentialDownload("sequential.txt");
        linkDownloader.parallelDownload("parallel.txt");
    }
}
