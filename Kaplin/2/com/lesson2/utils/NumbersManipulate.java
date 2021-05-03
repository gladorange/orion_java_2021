package com.lesson2.utils;

import java.util.Random;

abstract public class NumbersManipulate {
    Random rand = new Random();
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
        int bound = max - min;
        int random = 0;
        if(bound > 0) {
            random = rand.nextInt(bound) + min;
        }
        return random;

    }
    private int generateInt() {
        return rand.nextInt();

    }

    public void iterate() {
        for (int number : forSearchArray) {
            System.out.println(number);
        }
    }
}
