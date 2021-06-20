package com.orion.java.homework6.gasstation;

import com.orion.java.homework6.elementtypes.Triple;
import java.util.List;
import java.util.Comparator;
import java.util.Optional;


public class GasStationsManager {
    public static void findBestPrice(List<Triple<String,GasolineTypeClass,Double>> list, GasolineTypeClass type ){

        Comparator <Triple<String,GasolineTypeClass,Double>> comparator = Comparator.comparing( Triple::getThird );

        Optional<Triple<String, GasolineTypeClass, Double>> gasStation = list.stream()
                .filter( triple -> triple.getSecond().getType().equals( type.getType() ) )
                .min( comparator );
        gasStation.ifPresentOrElse(
                station -> System.out.println(station.getSecond() + ":"+ station.getFirst() ),
                () -> System.out.println("Error:Can't find it.")
        );
    }
}
