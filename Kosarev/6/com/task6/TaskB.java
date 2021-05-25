package com.task6;

import com.task6.Tuples.Pair;
import com.task6.Tuples.Triple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskB {

    enum GasolineType {
        A_92("АИ-92"),
        A_95("АИ-95"),
        A_98("АИ-98"),
        DT("ДТ");

        private String name;

        GasolineType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static String findBestPrice(List<Triple<String, GasolineType, Double>> gasStations, GasolineType type) {
        return gasStations.stream()
                .filter(gasPriceTriple -> gasPriceTriple.getSecond() == type)
                .min(Comparator.comparing(Triple::getThird)).orElseThrow()
                .getFirst();
    }

    private static List<Triple<String, Integer, Double>> sortAppsByVotesAmountAsc(List<Triple<String, Integer, Double>> appsMetrics) {
        return appsMetrics.stream()
                .sorted(Comparator.comparing(Pair::getSecond))
                .collect(Collectors.toList());
    }

    private static Triple<String, Integer, Double> bestChoiceApp(List<Triple<String, Integer, Double>> appsMetrics) {
        return appsMetrics.stream()
                .max(Comparator.comparing(Triple::getThird))
                .orElseThrow();
    }

    private static Triple<String, Integer, Double> worstChoiceApp(List<Triple<String, Integer, Double>> appsMetrics) {
        return appsMetrics.stream()
                .min(Comparator.comparing(Triple::getThird))
                .orElseThrow();
    }

    public static void run() {
        System.out.println("Задание Б. Списки, списки...:\n");
        System.out.println("Обработка списка с бензоколонками:");
        List<Triple<String, GasolineType, Double>> gasStations = List.of(
                new Triple<>("ул. Белинского, 20", GasolineType.A_92, 42.2),
                new Triple<>("ул. Белинского, 20", GasolineType.A_95, 44.2),
                new Triple<>("ул. Белинского, 20", GasolineType.A_98, 49.9),
                new Triple<>("ул. Белинского, 20", GasolineType.DT, 44.8),
                new Triple<>("пр. Гагарина, 538", GasolineType.A_92, 43.1),
                new Triple<>("пр. Гагарина, 538", GasolineType.A_95, 44.4),
                new Triple<>("пр. Гагарина, 538", GasolineType.A_98, 47.5),
                new Triple<>("ул. Деловая, 9", GasolineType.A_92, 41.8),
                new Triple<>("ул. Деловая, 9", GasolineType.A_95, 44.9),
                new Triple<>("ул. Деловая, 9", GasolineType.A_98, 48.5),
                new Triple<>("ул. Деловая, 9", GasolineType.DT, 44.3)
        );
        Arrays.stream(GasolineType.values())
                .forEach(gt -> System.out.printf("  %s дешевле всего купить на заправке по адресу %s%n",
                        gt.getName(),
                        findBestPrice(gasStations, gt))
                );

        System.out.println();
        System.out.println("Обработка списка с приложениями:");
        List<Triple<String, Integer, Double>> appsMetrics = List.of(
                new Triple<>("Facebook", 10000, 3.2),
                new Triple<>("Tik Tok", 7500, 4.1),
                new Triple<>("Youtube", 15000, 3.8),
                new Triple<>("Сбербанк Онлайн", 5000, 2.8),
                new Triple<>("Самокат", 1000, 4.5)
        );
        sortAppsByVotesAmountAsc(appsMetrics)
                .forEach(am -> System.out.printf("  Приложение \"%s\". Средняя оценка: %f (оценило %d пользователей)%n",
                        am.getFirst(),
                        am.getThird(),
                        am.getSecond())
                );
        System.out.printf("  Лучший выбор: %s%n", bestChoiceApp(appsMetrics).getFirst());
        System.out.println("  Худший выбор: " + worstChoiceApp(appsMetrics).getFirst());

        System.out.println("--------------------------------------------------------------");
    }
}
