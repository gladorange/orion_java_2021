package com.orion.lesson2;

public class Blocks {


    static int someVariable = 100_500;


    public static void main(String[] args) {

        System.out.println(someVariable);

        int a = 42;


        for (int i = 0; i < 10; i++) {
            int b = a;
            b = b + i;
        }


        //System.out.println(b);


        {
            int fortyTwo = 42;
            System.out.println(fortyTwo);
        }

       // System.out.println(fortyTwo);


    }


}
