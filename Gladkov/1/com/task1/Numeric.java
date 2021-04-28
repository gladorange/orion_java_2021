package com.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

 class Numeric {

     void enterNumeric(){
        Scanner scanner = new Scanner( System.in );
        Integer firstInt;
        Integer secondInt;

        System.out.println( "Введите первое число и нажмите \"Enter\"" );
        if( scanner.hasNextInt() ){
            firstInt = scanner.nextInt();
        }else {
            throw new InputMismatchException( "Вы ввели не число или вышли за границы типа Integer. "
                    + "Введеное значение: " + scanner.nextLine() );
        }

        System.out.println( "Введите второе число и нажмите \"Enter\"" );
        if( scanner.hasNextInt() ){
            secondInt = scanner.nextInt();
        }else {
            scanner.nextLine();
            throw new InputMismatchException( "Вы ввели не число или вышли за границы типа Integer. "
                    + "Введеное значение: " + scanner.nextLine() );
        }

        if( firstInt.equals( secondInt ) ){
            System.out.println("Число " + firstInt + " равно " + secondInt);
        }else {
            System.out.println((firstInt > secondInt) ?
                    "Число " + firstInt + " больше " + secondInt : "Число " + firstInt + " меньше " + secondInt);
        }

        long sum = 0L;
        sum = sum + firstInt + secondInt;
        System.out.println( "Сумма чисел: " + ( sum ) );
    }
}
