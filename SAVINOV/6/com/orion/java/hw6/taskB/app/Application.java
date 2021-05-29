package com.orion.java.hw6.taskB.app;

import com.orion.java.hw6.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Triple<String, Double, Double>> list = initApp();

        getSortedCountRating(list, SortedType.ASC);
        getSortedCountRating(list, SortedType.DESC);

        getSortedRating(list, SortedType.ASC);
        getSortedRating(list, SortedType.DESC);
    }

    static List<Triple<String, Double, Double>> initApp() {
        List<Triple<String, Double, Double>> listApp = new ArrayList<>();
        listApp.add(new Triple<>("Приложение 1", 65., 3.4));
        listApp.add(new Triple<>("Приложение 2", 15., 4.5));
        listApp.add(new Triple<>("Приложение 3", 45., 4.1));
        return listApp;
    }

    static void getSortedCountRating(List<Triple<String, Double, Double>> list, SortedType sortedType) {
        final Comparator<Triple<String, Double, Double>> tripleComparator = Comparator.comparing(Triple::getSecond);
        switch (sortedType) {
            case ASC:
                System.out.println("Отсортированный список по количеству оценок по возрастанию");
                list.stream()
                        .sorted(tripleComparator)
                        .forEach(x -> System.out.println(x.getFirst() + "\t" + x.getSecond()));
                break;
            case DESC:
                System.out.println("Отсортированный список по количеству оценок по убыванию");
                list.stream()
                        .sorted(tripleComparator.reversed())
                        .forEach(x -> System.out.println(x.getFirst() + "\t" + x.getSecond()));
                break;
        }
    }

    static void getSortedRating(List<Triple<String, Double, Double>> list, SortedType sortedType) {
        final Comparator<Triple<String, Double, Double>> tripleComparator = Comparator.comparing(Triple::getThird);
        switch (sortedType) {
            case ASC:
                System.out.println("Отсортированный список по среднему рейтингу по возрастанию");
                list.stream()
                        .sorted(tripleComparator)
                        .forEach(x -> System.out.println(x.getFirst() + "\t" + x.getThird()));
                break;
            case DESC:
                System.out.println("Отсортированный список по среднему рейтингу по убыванию");
                list.stream()
                        .sorted(tripleComparator.reversed())
                        .forEach(x -> System.out.println(x.getFirst() + "\t" + x.getThird()));
                break;
        }
    }
}
