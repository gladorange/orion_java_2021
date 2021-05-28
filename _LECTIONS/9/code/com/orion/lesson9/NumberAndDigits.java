package com.orion.lesson9;

public class NumberAndDigits {


    public static void main(String[] args) {
        Runnable digitTask = () -> {
            char digits[] = {'0', '1', '2'};
            int i = 0;
            while (true) {
                System.out.println(digits[i++ % digits.length]);
            }
        };

        Runnable lettersTask = () -> {
            char digits[] = {'a', 'b', 'c'};
            int i = 0;
            while (true) {
                System.out.println(digits[i++ % digits.length]);
            }
        };

        new Thread(digitTask).start();
        new Thread(lettersTask).start();

    }

}
