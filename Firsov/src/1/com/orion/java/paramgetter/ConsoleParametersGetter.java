package com.orion.java.paramgetter;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.orion.java.main.Main;
import read.usemsg.Usemsg;

/**
 * Класс считывания параметров с консоли.
 */
public class ConsoleParametersGetter implements ParametersGetter {
    /**
     * Конструктор класса.
     */
    public ConsoleParametersGetter(){
        while(true) {
            System.out.println("Are you sure that you want to use console for inserting values (yes/no/help) ?");
            Scanner console = new Scanner(System.in);
            String answer = console.nextLine();
            if (answer.equals("yes")) {
                break;
            } else if (answer.equals("no")) {
                System.exit(0);
            } else if (answer.equals("help")) {
                String inputFileName = Main.class.getResource("Usemsg.txt").toString().substring(5);
                Usemsg.show(inputFileName);
                System.exit(0);
            } else {
                System.out.println("Incorrect answer.Try again...");
            }
        }
    }
    /**
     * Метод получения параметров с консоли.
     * @param integerValues Массив, куда записываются считанные значения чисел.
     * @param args Аргументы, переданные в командную строку.
     */
    public void getParameters(Integer[] integerValues,String[] args){
        int integerValuesSize = integerValues.length;
        Integer countNumbers = 0;
        while(true){
            Scanner console = new Scanner(System.in);
            System.out.println("Insert " + (countNumbers + 1) + " number:");
            try {
                // если доходит до сюда - число
                Integer value = console.nextInt();
                System.out.println("Inserted number is |"+value+"|");
                integerValues[countNumbers] = value;
                countNumbers ++;
                if(countNumbers.equals(integerValuesSize)){
                    break;
                }
            } catch (InputMismatchException e) {
                // если доходит сюда - не число
                System.out.println("Error: Inserted number isn't digest ");
                System.out.println("Try again:");
            }
        }
    }
}
