package com.orion.java.hw2;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = initArray(10);
        System.out.println("массив " + arrayList.toString());
        printNumbersOppositeSigns(arrayList);
    }

    private static ArrayList<Integer> initArray(int length) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arrayList.add(random.nextInt());
        }
        return arrayList;
    }

    private static void printNumbersOppositeSigns(ArrayList<Integer> arrayList){
        int previosNumber = 0;
        for (int number : arrayList) {
            if ((long) previosNumber * number < 0)
                System.out.printf("Числа с противоположными знаками обнаружены: %d %d\n", previosNumber, number);
            previosNumber = number;
        }
    }
}
