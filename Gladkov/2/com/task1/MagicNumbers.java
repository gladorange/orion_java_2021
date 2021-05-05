package com.task1;

import java.util.Random;

public class MagicNumbers {

   public static int[] getArrRandomNumbers( int arrLength, int min, int max  ){
       int [] arrNumbers = new int [arrLength];
       Random random = new Random();
       for( int i = 0; i<arrNumbers.length; i++ ){
            arrNumbers[i] = random.nextInt(max - min ) + min;
       }
       return arrNumbers;
   }

   private boolean isMagicNumber( int number ) {
       if( Math.abs( number ) < 10 ){
           return false;
       }else {
           while ( true ) {
               int singleNumberLast = number % 10;
               number /= 10;
               int singleNumberPrev = number % 10;
               if ( number == 0 ) {
                   return true;
               }
               if ( Math.abs( singleNumberLast ) != Math.abs( singleNumberPrev ) ) {
                   return false;
               }
           }
       }
   }

   public void printMagicNumber( int [] intArr ){
       for ( int j : intArr ) {
           if ( isMagicNumber(j) ) {
               System.out.printf( "Число %d - магическое!\n", j );
           }
       }
   }

}
