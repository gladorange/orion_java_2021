package com.orion.java.hw6.taskB.gasoline;

import com.orion.java.hw6.Triple;

import java.util.*;

public class Gasoline {
    public static void main(String[] args) {
        printResult(findBestPrice(initGasoline(), GasolineType.AI_92));
        printResult(findBestPrice(initGasoline(), GasolineType.AI_95));
        printResult(findBestPrice(initGasoline(), GasolineType.AI_98));
        printResult(findBestPrice(initGasoline(), GasolineType.DT));
    }

    static List<Triple<String, GasolineType, Double>> initGasoline() {
        List<Triple<String, GasolineType, Double>> listGasoline = new ArrayList<>();
//        listGasoline.add(new Triple<>("ул. Первая, д. 12", GasolineType.DT, 47.5));
//        listGasoline.add(new Triple<>("ул. Первая, д. 21", GasolineType.DT, 46.5));
        listGasoline.add(new Triple<>("ул. Вторая, д. 32", GasolineType.AI_92, 45.2));
        listGasoline.add(new Triple<>("ул. Вторая, д. 23", GasolineType.AI_92, 44.2));
        listGasoline.add(new Triple<>("ул. Третья, д. 65", GasolineType.AI_95, 48.30));
        listGasoline.add(new Triple<>("ул. Третья, д. 56", GasolineType.AI_95, 47.30));
        listGasoline.add(new Triple<>("ул. Четвертая, д. 102", GasolineType.AI_98, 50.4));
        listGasoline.add(new Triple<>("ул. Четвертая, д. 201", GasolineType.AI_98, 51.4));
        return listGasoline;
    }

    static Optional<Triple<String, GasolineType, Double>> findBestPrice(List<Triple<String, GasolineType, Double>> list, GasolineType type) {
        return list.stream()
                .filter(triple -> triple.getSecond().equals(type))
                .min(Comparator.comparing(Triple::getThird));
    }

    private static void printResult(Optional<Triple<String, GasolineType, Double>> list) {
        if (list.isPresent()) {
            System.out.println(list.get().getFirst());
        } else {
            System.out.println("Тип топлива не найден в списке");
        }
    }
}
