package com.orion.lesson9;

import java.util.ArrayList;
import java.util.List;

public class ArraysList {


    volatile static int counter = 0;

    static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
        List<Integer> integerList = new ArrayList<>();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    synchronized (lock) {
                        counter = counter + 1;
                    }
                }
            }
        };


        final Thread thread = new Thread(task);
        thread.start();
        final Thread thread1 = new Thread(task);
        thread1.start();


        thread.join();
        thread1.join();
        System.out.println(counter);


    }
}
