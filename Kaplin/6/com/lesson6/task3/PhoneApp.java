package com.lesson6.task3;

import com.lesson6.utils.Triple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PhoneApp {

    public static void showSortedByEstimCount( List<Triple<String, Integer ,Double>> appList, boolean asc ){
        Comparator <Triple<String, Integer ,Double>> comparatorNumberOfRatings = Comparator.comparing(Triple::getSecond);
        appList.sort( comparatorNumberOfRatings );
        String sortName = "От меньшего к большему";
        if(!asc) {
            sortName = "От большего к меньшему";
            Collections.reverse( appList );
        }
        System.out.println(sortName);
        appList.forEach( a-> System.out.printf("Название: %s, Количество оценок: %s, Средний рейтинг: %s%n",
                a.getFirst() , +a.getSecond(), a.getThird()));
    }

    public static void showMinMaxByRating(List<Triple<String, Integer ,Double>> appList) {
        Comparator <Triple<String, Integer ,Double>> comparatorRating = Comparator.comparing(Triple::getThird);
        Triple<String, Integer ,Double> max = Collections.max( appList, comparatorRating );
        Triple<String, Integer ,Double> min = Collections.min( appList, comparatorRating );
        System.out.printf("Приложение с минимальным рейтингом:%n Название: %s, Количество оценок: %s, Средний рейтинг: %s%n",
                min.getFirst(), min.getSecond(), min.getThird());
        System.out.printf("Приложение с максимальным рейтингом:%n Название: %s, Количество оценок: %s, Средний рейтинг: %s%n",
                max.getFirst(), max.getSecond(), max.getThird());
    }

    public static Integer getRandomEstim() {
        return ThreadLocalRandom.current().nextInt(0, 10000);
    }

    public static Double getRandomRating() {
        return ThreadLocalRandom.current().nextDouble(1.0,  5.0);
    }
}
