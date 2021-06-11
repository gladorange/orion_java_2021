package com.orion.lesson6.task;

import com.orion.lesson6.tuple.Pair;
import com.orion.lesson6.tuple.Triple;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TaskC implements Task {

    public List<Triple<String, Integer, Double>> mobileList;

    @Override
    public void initData() {
        mobileList = List.of(
                new Triple<String, Integer, Double>("ShmugenGames", 5000, 5.0),
                new Triple<String, Integer, Double>("VashuNote", 25149, 4.69),
                new Triple<String, Integer, Double>("Another one app", 785, 3.25),
                new Triple<String, Integer, Double>("ShmugenGames", 127000, 4.0)
        );
    }

    @Override
    public void printData() {
        mobileList.forEach(e -> System.out.println(String.format("Приложение %s имеет %s оценок и средний балл %s", e.getFirst(), e.getSecond(), e.getThird())));
    }

    @Override
    public void actionTask() {
        sortByCountData();
        sortByMaxData();
        sortByMinData();
    }


    private void sortByCountData(){

        System.out.println("Сортировка приложений по колву оценок: ");

        mobileList = mobileList.stream()
                .sorted(Comparator.comparing(Triple::getSecond))
                .collect(Collectors.toList());

        printData();
    }

    private void sortByMaxData(){
        System.out.println(String.format("Приложение с лучшим рейтингом: %s", mobileList.stream().max(Comparator.comparing(Triple::getThird)).get().getFirst()));
    }

    private void sortByMinData(){
        System.out.println(String.format("Приложение с худшим рейтингом: %s", mobileList.stream().min(Comparator.comparing(Triple::getThird)).get().getFirst()));
    }

}
