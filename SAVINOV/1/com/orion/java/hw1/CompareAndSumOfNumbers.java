package com.orion.java.hw1;

import java.util.Scanner;

public class CompareAndSumOfNumbers {
    public static void main(String[] args) {

        Integer firstNumber = checkEnterNumber("Введите первое целое число:");
        Integer secondNumber = checkEnterNumberRecursive("Введите второе целое число:");

        System.out.printf("Первое число: %s, второе число: %s" + System.lineSeparator(), firstNumber, secondNumber);

        if (firstNumber > secondNumber)
            System.out.printf("Число %s больше %s" + System.lineSeparator(), firstNumber, secondNumber);

        if (firstNumber < secondNumber)
            System.out.printf("Число %s меньше %s" + System.lineSeparator(), firstNumber, secondNumber);

        System.out.println("Сумма чисел: " + (firstNumber + secondNumber));
    }

    private static Integer checkEnterNumber(String text) {
        boolean isInteger = false;
        Integer firstNumber = 0;
        do {
            Scanner console = new Scanner(System.in);
            System.out.println(text);
            if (console.hasNextInt()) {
                firstNumber = console.nextInt();
                isInteger = true;
            }
        } while (!isInteger);
        return firstNumber;
    }

    private static Integer checkEnterNumberRecursive(String text) {
        Scanner console = new Scanner(System.in);
        System.out.println(text);
        if (console.hasNextInt())
            return console.nextInt();
        else
            return checkEnterNumberRecursive(text);
    }
}
