package com.lesson6.task3;

import com.lesson6.Triple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneApp {

    public static void sortedApp( List<Triple<String, Integer ,Double>> appList ){
        Comparator <Triple> comparatorNumberOfRatings = Comparator.comparing( o -> ( (Integer) o.getSecond() ) );
        Comparator <Triple> comparatorRating = Comparator.comparing( o -> ( (Double) o.getThird() ) );

        appList.sort( comparatorNumberOfRatings );
        Collections.reverse( appList );
        Triple max = Collections.max( appList, comparatorRating );
        Triple min = Collections.min( appList, comparatorRating );
        appList.forEach( a-> System.out.println( a.getFirst() +"  "+a.getSecond()+"  " +a.getThird() ) );
        System.out.println("/*****************************************/");
        System.out.println("Приложение с минимальным рейтингом: "+ min.getFirst() +"  "+min.getSecond()+"  " +min.getThird());
        System.out.println("Приложение с максимальным рейтингом: "+ max.getFirst() +"  "+max.getSecond()+"  " +max.getThird());

    }
}
