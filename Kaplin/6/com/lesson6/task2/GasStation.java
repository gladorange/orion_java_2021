package com.lesson6.task2;

import com.lesson6.utils.Triple;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GasStation {
    public static void findBestPrice(List<Triple<String,GasolineType,Double>> list, GasolineType type ){

        Comparator <Triple<String,GasolineType,Double>> comparator = Comparator.comparing( Triple::getThird );

        Optional<Triple<String, GasolineType, Double>> gasStation = list.stream()
                .filter( triple -> triple.getSecond() == type )
                .min( comparator );
        gasStation.ifPresentOrElse(
                station -> System.out.printf("Самый дешевый %s по адресу %s - %s рублей за литр%n",
                        station.getSecond().toString(), station.getFirst(), station.getThird()),
                () -> System.out.println("Такого бензина нет")
        );
    }
}





