package com.lesson2.utils;

import java.util.Random;

abstract public class NumbersManipulate {
    public int[] forSearchArray;

    public NumbersManipulate(int size, int min, int max) {
        forSearchArray = createNumberArray(size, min, max);
    }
    public NumbersManipulate(int size) {
        forSearchArray = createNumberArray(size);
    }

    private int[] createNumberArray(int size, int min, int max) {
        int[] forGenerateArray = new int[size];
        for (int i = 0; i < forGenerateArray.length; i++) {
            forGenerateArray[i] = generateInt(min, max);
        }
        return forGenerateArray;
    }
    private int[] createNumberArray(int size) {
        int[] forGenerateArray = new int[size];
        for (int i = 0; i < forGenerateArray.length; i++) {
            forGenerateArray[i] = generateInt();
        }
        return forGenerateArray;
    }

    private int generateInt(int min, int max) {
        Random rand = new Random();
        System.out.println(max-min);
        return rand.nextInt(max - min) + min;

    }
    private int generateInt() {
        Random rand = new Random();
        return rand.nextInt();

    }

    public void iterate() {
        for (int number : forSearchArray) {
            System.out.println(number);
        }
    }
}
