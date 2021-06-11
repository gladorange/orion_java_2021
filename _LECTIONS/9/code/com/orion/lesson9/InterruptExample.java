package com.orion.lesson9;

public class InterruptExample {


    public static void main(String[] args) throws InterruptedException {


        Thread sleep = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Засыпаю");
                try {
                    Thread.sleep(100_000);
                } catch (InterruptedException e) {
                    System.out.println("Меня разбудили");
                }
            }
        });


        sleep.start();


        Thread.sleep(2000);
        sleep.interrupt();


        System.out.println("Конец");
    }
}
