package com.task1;

import java.util.Scanner;


class Task1App {
    private int num1, num2;

    public void getNumbers(String[] args) {
        String num1str, num2str;

        if (args.length == 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите два числа через пробел: ");
            num1str = in.next();
            num2str = in.next();
        } else {
            num1str = args[0];
            num2str = args[1];
        }

        try {
            this.num1 = Integer.parseInt(num1str);
            this.num2 = Integer.parseInt(num2str);
        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка ввода - ставлю все значения по умолчанию");
            this.num1 = 1;
            this.num2 = 2;
        }
    }

    public void printState() {
        System.out.println("");
        System.out.printf("Число 1: %d\n", this.num1);
        System.out.printf("Число 2: %d\n", this.num2);
        if (this.num1 > this.num2) {
            System.out.printf("Число %d больше %d\n", this.num1, this.num2);
        } else if (this.num1 < this.num2) {
            System.out.printf("Число %d меньше %d\n", this.num1, this.num2);
        }
        System.out.printf("Сумма чисел: %d\n", this.num1+this.num2);
    }
}


public class Main {
    public static void main(String[] args) {
        Task1App myapp = new Task1App();
        myapp.getNumbers(args);
        myapp.printState();
    }
}
