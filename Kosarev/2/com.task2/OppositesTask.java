package com.task2;


import java.util.Random;


public class OppositesTask {

    public static final int ARRAY_SIZE = 10;
    private final Random rand = new Random();

    public void run() {
        System.out.println("Влечение противоположностей\n");
        // Array init
        int[] testArray = new int[OppositesTask.ARRAY_SIZE];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = rand.nextInt();
            System.out.printf("%d ", testArray[i]);
        }
        System.out.println("\n");

        for (int i = 0; i < testArray.length-1; i++) {
            if (testArray[i] == 0 || testArray[i+1] == 0)
                continue;

            if (OppositesTask.isOppositeSign(testArray[i], testArray[i+1])) {
                System.out.println("Числа с противоположными знаками обнаружены: " +
                        testArray[i] + " " + testArray[i+1]);
            }
        }
    }

    public static boolean isOppositeSign(int x, int y) {
        return ((long)x * (long)y) < 0;
    }

}
