package com.orion.lesson9;

import java.util.List;

public class WaitNotify {


    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();


       // List list = new ArraysList();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock) {
                //    list.add();
                    lock.notify();
                }

            }
        });
        t.start();

        synchronized (lock) {
         //   list.init
            lock.wait();
        //    list.work
        }

        System.out.println("Конец ");
    }
}
