package com.orion.lesson2;

public class VarArg {


    public static void main(String[] args) {

        printSum("Two numbers",2, 3);
        printSum("Three numbers",10,20,30);

        int[] ints = {1, 2, 3, 4};
        printSum("Array",ints);
    }



    static void printSum(String intro, int... ints) {
        System.out.println(intro);

        int sum = 0;

        for (int anInt : ints) {
            sum += anInt;
        }

        System.out.println("Sum = " + sum);

    }
}
