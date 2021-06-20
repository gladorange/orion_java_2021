package com.orion.java.homework6.phoneapplication;

import com.orion.java.homework6.elementtypes.Triple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneApplicationClass {
    public static void sortedApp( List<Triple<String, Integer ,Double>> appList ){
        Comparator<Triple> evaluationsNumber = Comparator.comparing(o -> ( (Integer) o.getSecond() ) );
        Comparator <Triple>   ratingComparator = Comparator.comparing( o -> ( (Double) o.getThird() ) );

        appList.sort( evaluationsNumber );
        System.out.println("----Application sorted by evaluations number-----");
        appList.forEach( a-> System.out.println( a.getFirst() +"  "+a.getSecond()+"  " +a.getThird() ) );
        System.out.println("---end----");
        Triple max = Collections.max( appList, ratingComparator );
        Triple min = Collections.min( appList, ratingComparator );
        System.out.println("Min applications rating : "+ min.getFirst() +"  "+min.getSecond()+"  " +min.getThird());
        System.out.println("Max applications rating : "+ max.getFirst() +"  "+max.getSecond()+"  " +max.getThird());

    }
}
