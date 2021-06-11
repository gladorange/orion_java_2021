package com.orion.lesson6.task;

import com.orion.lesson6.tuple.Triple;

import java.util.*;

public class TaskB implements Task {

    public static List<Triple<String, GasolineType, Double>> dataList;

    public static enum GasolineType {
        DT("ДТ"),
        AI92("АИ-92"),
        AI95("АИ-95"),
        AI98("АИ-98");

        private final String name;

        GasolineType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    @Override
    public void initData() {
        dataList = List.of(
                new Triple<String, GasolineType, Double>("Горького, 18", GasolineType.AI92, 95.50),
                new Triple<String, GasolineType, Double>("Гагарина, 222", GasolineType.DT, 94.50),
                new Triple<String, GasolineType, Double>("Рокоссовского, 10", GasolineType.AI95, 96.00),
                new Triple<String, GasolineType, Double>("Минина, 1", GasolineType.AI92, 94.00));
    }

    @Override
    public void printData() {
        dataList.forEach(e -> System.out.println(String.format("По адресу %s продаётся %s за %s", e.getFirst(), e.getSecond(), e.getThird())));
    }

    @Override
    public void actionTask() {

        GasolineType randomType = new ArrayList<GasolineType>(Arrays.asList(GasolineType.values())).get(new Random().nextInt(GasolineType.values().length));
        findBestGasPrice(randomType);

    }

    private static void findBestGasPrice(GasolineType type) {

        Optional<Triple<String, GasolineType, Double>> optional = dataList.stream().filter(e -> e.getSecond().equals(type)).min(Comparator.comparing(Triple::getThird));
        if(optional != null){
            System.out.println(String.format("Наиболее выгодная цена для %s находится по адресу %s", type, optional.get().getFirst()));
        }else{
            System.out.println("Данных по искомому типу бензина нет");
        }

    }

}
