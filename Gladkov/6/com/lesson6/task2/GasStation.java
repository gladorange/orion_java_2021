package com.lesson6.task2;

import com.lesson6.Triple;

import java.util.Comparator;
import java.util.List;

public class GasStation {

    public static void findBestPrice( List<Triple<String,GasolineType,Double>> list, GasolineType type ){

        Comparator <Triple> comparator = Comparator.comparing( o -> ( (Double) o.getThird() ) );

        Triple<String, GasolineType, Double> gasStation = list.stream()
                .filter( triple -> triple.getSecond().getType().equals( type.getType() ) )
                .min( comparator ).get();
        System.out.println( gasStation.getFirst() );
    }
}
