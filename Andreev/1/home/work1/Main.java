package home.work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите поочередно два целых числа:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer numberOne = Integer.parseInt(br.readLine());

        Integer numberTwo = Integer.parseInt(br.readLine());

        if (numberOne > numberTwo) {
            System.out.printf("Число %d больше %d", numberOne, numberTwo);
        } else if (numberOne < numberTwo) {
            System.out.printf("Число %d меньше %d", numberOne, numberTwo);
        }

        int sum = numberOne + numberTwo;

        System.out.println();
        System.out.println("Сумма чисел: " + sum);

    }
}
