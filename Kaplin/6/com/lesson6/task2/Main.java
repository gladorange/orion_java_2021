package com.lesson6.task2;

import com.lesson6.utils.Triple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Triple<String, GasolineType, Double>> gasStationList =
                new ArrayList<>(Arrays.asList(
                        new Triple<>("Ленина 666", GasolineType.DT, 45.3),
                        new Triple<>("Балахна 1", GasolineType.AI92, 46.1),
                        new Triple<>("Гагарина 54", GasolineType.AI92, 42.1),
                        new Triple<>("Петухово 6", GasolineType.AI92, 41.1),
                        new Triple<>("Минина 1", GasolineType.AI95, 48.2),
                        new Triple<>("Кремль корпус 2", GasolineType.AI98, 49.5)
                ));

        GasStation.findBestPrice(gasStationList, GasolineType.AI92);
    }
}