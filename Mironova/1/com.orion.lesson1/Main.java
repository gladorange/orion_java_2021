package com.orion.java.lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int numberOne = in.nextInt();

        System.out.println("Enter second number: ");
        int numberTwo = in.nextInt();

        if(numberOne > numberTwo){
            System.out.println("The first number is bigger than the second");
        }else{
            System.out.println("The second number is bigger than the first");
        }

        int summa = numberOne + numberTwo;

        System.out.println("The sum of two numbers is " + summa);

    }

}