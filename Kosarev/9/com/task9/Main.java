package com.task9;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> listOfURLs = List.of("https://ya.ru/",
                                          "https://vk.com/",
                                          "https://ru-ru.facebook.com/",
                                          "https://www.instagram.com/",
                                          "https://orioninc.zoom.us/",

                                          "https://www.java.com/ru/",
                                          "https://en.wikipedia.org/wiki/Main_Page",
                                          "https://stackoverflow.com/",
                                          "https://habr.com/ru/",
                                          "https://www.python.org/",

                                          "https://www.jetbrains.com/ru-ru/idea/",
                                          "https://www.jetbrains.com/pycharm/",
                                          "https://refactoring.guru/",
                                          "https://twitter.com/",
                                          "https://github.com/",

                                          "https://www.spotify.com/ru-ru/",
                                          "https://www.apple.com/ru/",
                                          "https://www.nintendo.ru/",
                                          "https://www.microsoft.com/ru-ru",
                                          "https://www.google.com/");

        System.out.println("List of URLs:\n    - " + String.join("\n    - ", listOfURLs));
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("SequentialDownloader benchmark:");
        System.out.println();
        Downloader sequential = new SequentialDownloader("sequential.txt");
        sequential.benchmark(listOfURLs);
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("ParallelSortedDownloader benchmark:");
        System.out.println();
        Downloader parallelSorted = new ParallelSortedDownloader("parallelSorted.txt");
        parallelSorted.benchmark(listOfURLs);
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("ParallelUnsortedDownloader benchmark:");
        System.out.println();
        Downloader parallelUnsorted = new ParallelUnsortedDownloader("parallelUnsorted.txt");
        parallelUnsorted.benchmark(listOfURLs);
        System.out.println("---------------------------------------------------------------------------");
    }
}
