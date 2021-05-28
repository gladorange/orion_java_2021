package com.orion.lesson9;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler {


    public static void main(String[] args) {


        final Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(42 / 0);
            }
        };
        thread.start();
        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Случилось исключение " + e.getMessage());
            }
        });


        System.out.println("Конец прогарммы");


    }
}
