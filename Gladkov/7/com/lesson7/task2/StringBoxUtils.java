package com.lesson7.task2;

import com.lesson7.Box;

import java.util.Arrays;
import java.util.List;

public class StringBoxUtils {

    public static Box<? extends CharSequence> join( List<Box<? extends CharSequence>> list ){
       return Box.of( concat( list ) );
    }

    public static Box<? extends CharSequence> join( Box<? extends CharSequence> ... varargs ){
        return Box.of( concat(Arrays.asList( varargs ) ));
    }

    public static void copyNonEmptyStringBoxToList( Box<? extends CharSequence>boxString, List<? super CharSequence> list ){
       if( boxString.get().toString().trim().length() !=0 ){
           list.add( boxString.get() );
       }
    }

    private static String concat( List<Box<? extends CharSequence>> list ){
        StringBuilder result = new StringBuilder();
        for ( Box box : list ){
            result.append(box.get().toString());
        }
        return result.toString();
    }
}
