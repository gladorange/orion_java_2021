package com.task2;


import java.util.Random;


public class MagicNumberTask {

    public static final int ARRAY_SIZE = 100;
    public static final int LOWER_BORDER = -100;
    public static final int UPPER_BORDER = 100;
    private final Random rand = new Random();

    public void run() {
        System.out.println("Магия чисел\n");
        int[] testArray = new int[MagicNumberTask.ARRAY_SIZE];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = this.nextRandomInt(MagicNumberTask.LOWER_BORDER, MagicNumberTask.UPPER_BORDER);
            if (MagicNumberTask.isMagicNumber(testArray[i])) {
                System.out.printf("Число %d - магическое!\n", testArray[i]);
            }
        }
    }

    public static boolean isMagicNumber(int num) {
//        return MagicNumberTask.isMagicNumberStr(num);
        return MagicNumberTask.isMagicNumberDiv(num);
    }

    private static boolean isMagicNumberDiv(int num) {
        return (num / 10) == (num % 10);
    }

    private static boolean isMagicNumberStr(int num) {
        // remove sign and convert to str
        String numToString = String.valueOf(Math.abs(num));
        for (int i = 1; i < numToString.length(); i++) {
            if (numToString.charAt(i) != numToString.charAt(0))
                return false;
        }
        return true;
    }

    private int nextRandomInt(int lower, int upper) {
        return this.rand.nextInt(upper - lower) + lower;
    }

}
