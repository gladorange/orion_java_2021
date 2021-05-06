package com.orion.java;

import java.util.Random;

/**
 * Класс,содержащий точку входа  в приложение.
 */
public class Main {
    /**
     * Метод определяет "магическое" число.
     * @param number
     * @return Возвращает true,если число "магическое",иначе false.
     */
    public static boolean isMagicNumber(int number){
        if((  ((number/10) == (number%10)) && (number!=0) )){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Метод определяет имеют ли два числа различные знаки.
     * @param firstNumber
     * @param secondNumber
     * @return  Возвращает 1,если числа имеют разные знаки.
     * Возвращает -1,если числа имеют разные знаки.
     * Возвращает 0,если одно из чисел равно нулю.
     */
    public  static int isDifferentSignum(int firstNumber,int secondNumber){
        if( (firstNumber == 0) || (secondNumber == 0 ) ){
            return 0;
        }
        if(  (Math.signum(firstNumber)) == (Math.signum(secondNumber))  ){
            return -1;
        }else{
            return 1;
        }
    }

    /**
     * Точка входа в приложение.
     * @param args
     */
    public static void main(String[] args) {
        Random r = new Random();
        int[] myArray = new int[100];
        int array1Size = myArray.length;
        for (int i = 0; i < array1Size ; i++) {
            if(r.nextBoolean()){
                myArray[i]  = r.nextInt(101);
            }else{
                myArray[i] = (-1)*r.nextInt(101);
            }
        }

        for (int i = 0; i < array1Size ; i++) {
            if( isMagicNumber(myArray[i]) ){
                System.out.println("Число <"+myArray[i]+"> - магическое!");
            }
        }

        myArray=null;
        System.out.println("----");
        myArray = new int[10];
        array1Size = myArray.length;
        for (int i = 0; i < array1Size ; i++) {
            myArray[i]  = r.nextInt();
            System.out.println(myArray[i]);
        }
        System.out.println("----");
        for (int i = 0; i < array1Size; i++) {
            if(i+1 != array1Size){

                if( isDifferentSignum(myArray[i],myArray[i+1]) == 1 ){
                    System.out.println("Числа с противоположными знаками обнаружены: "+myArray[i] + " "+myArray[i+1]);
                }
            }
        }
    }
}
