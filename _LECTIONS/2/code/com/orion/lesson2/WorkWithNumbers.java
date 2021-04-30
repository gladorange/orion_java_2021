package com.orion.lesson2;

import java.math.BigDecimal;

public class WorkWithNumbers {


    public static void main(String[] args) {
      /*  byte one = 1;
        byte another = 2;


        final int i = one + another;
*/


        BigDecimal one = BigDecimal.valueOf(.2);
        BigDecimal two = BigDecimal.valueOf(.1);

        System.out.println(BigDecimal.valueOf(.3).equals(one.add(two)));



    }



}
