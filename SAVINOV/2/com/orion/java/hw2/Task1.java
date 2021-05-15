package com.orion.java.hw2;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        outputMagicNumber(initArray(100));
    }
    private static int[] initArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = randomInt(-100, 100);
        }
        return array;
    }
    private static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    private static void outputMagicNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (isMagicNumber(array[i]))
                System.out.printf("Число %d - магическое!\n", array[i]);
        }
    }
    private static boolean isMagicNumber(int number) {
        int remainderDivision = number % 10;
        number = number / 10;

        if (number == 0)
            return false;
        else {
            while (number % 10 != 0) {
                if (remainderDivision == number % 10) {
                    remainderDivision = number % 10;
                    number = number / 10;
                } else return false;
            }
            return true;
        }
    }
}
