package com.orion.lesson2;

public class OneAmpersondVsTwo {


    public static void main(String[] args) throws InterruptedException {


        if (true | isTrue() ) {
            System.out.println("Все хорошо");
        }
    }




    static boolean isTrue() throws InterruptedException {
        System.out.println("Начинаю долго считать");
        Thread.sleep(2000);
        return true;
    }
}
