package com.lessom1.task1;

import java.util.Scanner;

public class IntegerManipulate {
    
    private Integer firstVar = null;
    private Integer secondVar = null;
    private String currentInput;
    private Scanner scan = new Scanner( System.in );

    public void runManipulate() {

        this.inputFirst();
        this.inputSecond();

        this.printCompareResult();
        this.printSum();
    }

    private void inputFirst() {
        while(this.firstVar == null) {
            System.out.println( "Введите первое число и нажмите \"Enter\"" );
            this.currentInput = scan.nextLine();
            if( this.isInteger(this.currentInput) ){
                this.firstVar = Integer.parseInt(this.currentInput);
            } else {
                System.out.printf( "Вы ввели что-то неподходящее, у вас получилось: %s" + System.lineSeparator(), this.currentInput );
                System.out.println( "Ничего страшного, попробуйте снова");
            }
        }
    }


    private void inputSecond() {
        while(this.secondVar == null) {
            System.out.println( "Введите второе число и нажмите \"Enter\"" );
            this.currentInput = scan.nextLine();
            if( this.isInteger(this.currentInput) ){
                this.secondVar = Integer.parseInt(this.currentInput);

            } else {
                System.out.printf( "Вы ввели что-то неподходящее, у вас получилось: %s" + System.lineSeparator(), this.currentInput );
                System.out.println( "Ничего страшного, попробуйте снова");
            }
        }


    }

    private void printCompareResult() {
        String scaleString = "равно";
        if( !firstVar.equals( secondVar ) ){
            scaleString = firstVar > secondVar ? "больше" : "меньше";
        }
        System.out.println(this.secondVar);
        System.out.printf("Число %d %s %d" + System.lineSeparator(), this.firstVar, scaleString, this.secondVar);
    }

    private void printSum() {
        int sum = this.firstVar + this.secondVar;
        System.out.printf("Сумма этих прекрасных чисел: %d", sum);
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }


}
