package com.orion.lesson3;

import java.util.Arrays;

public class EnumExample {

    enum Season {
        SUMMER(10),
        WINTER(-10);


        final int averageTempr;

        Season(int averageTempr) {
            this.averageTempr = averageTempr;
        }

        @Override
        public String toString() {
            return name();
        }
    }

    final static String SUMMER_C = "лето";
    final static String WINTER_C = "зима";

    public static int getAvgTemp(Season season) {
        return season.averageTempr;
    }


    public static void main(String[] args) {
       // System.out.println(getAvgTemp(Season.SUMMER));
       // System.out.println(getAvgTemp(Season.SUMMER));


        final Season summer = Season.valueOf("SUMMER");
        System.out.println(summer.name());

        //  System.out.println(Arrays.toString(Season.values()));
    }
}
