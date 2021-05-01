package com.task2;

import java.util.Arrays;
import java.util.Random;

public class AttractionOpposites {

    public static int[] getArrRandomNumbers( int arrLength ){
        Random random = new Random();
        int [] arrNumbers = new int [arrLength];

        for( int i = 0; i<arrNumbers.length; i++ ){
            arrNumbers[i] = random.nextInt();
        }

        System.out.println( "Массив " + Arrays.toString( arrNumbers ) );
        return arrNumbers;
    }

    public void adjacentNumbers( int[]intArr ){
        for ( int i = 0; i < intArr.length; i++ ){
            if( intArr[i] < 0 ){
                if( i > 0 ){
                    if( intArr[ i-1 ] > 0 ){
                        System.out.printf( "Числа с противоположными знаками обнаружены: %d %d \n", intArr[i-1], intArr[i] );
                    }
                }
                if( i < (intArr.length - 1) ) {
                    if ( intArr[i + 1] > 0 ) {
                        System.out.printf( "Числа с противоположными знаками обнаружены: %d %d \n", intArr[i], intArr[i + 1] );
                    }
                }
            }
        }
    }
}
