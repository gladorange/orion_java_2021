package com.lesson6.task2;

import com.lesson6.Triple;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GasStation {

    public static void findBestPrice( List<Triple<String,GasolineType,Double>> list, GasolineType type ){

        Comparator <Triple<String,GasolineType,Double>> comparator = Comparator.comparing( Triple::getThird );

        Optional<Triple<String, GasolineType, Double>> gasStation = list.stream()
                .filter( triple -> triple.getSecond().getType().equals( type.getType() ) )
                .min( comparator );
        gasStation.ifPresentOrElse(
                station -> System.out.println( station.getFirst() ),
                () -> System.out.println("Данная марка бензина не обнаружена.")
        );
    }
}
