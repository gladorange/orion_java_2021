package com.orion.lesson2;

public class IntegerVsInt {

    public static void main(String[] args) {


        final long start = System.currentTimeMillis();
        fillPrimitive();
        System.out.println("End primitive " + (System.currentTimeMillis() - start));


        final long start2 = System.currentTimeMillis();
        fillObject();
        System.out.println("End object " + (System.currentTimeMillis() - start2));


    }

    private static void fillPrimitive() {
        int[] ints = new int[10_000_000];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;

        }

        System.out.println(ints[5000]);
    }

    private static void fillObject() {
        Integer[] ints = new Integer[10_000_000];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;

        }

        System.out.println(ints[5000]);
    }
}
