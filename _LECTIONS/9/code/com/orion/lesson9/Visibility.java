package com.orion.lesson9;

public class Visibility extends Thread {

    volatile boolean keepRunning = true;
    volatile long someValue = 12312;

    public void run() {
        long count = 0;
        while (keepRunning) {
            count++;
        }

        System.out.println("Thread terminated." + count);
    }

    public static void main(String[] args) throws InterruptedException {
        Visibility t = new Visibility();
        t.start();
        Thread.sleep(1000);
        System.out.println("after sleeping in main");

        t.keepRunning = false;
        // System.out.println("keeprunning=" + t.keepRunning);

        t.join();

        System.out.println("keepRunning set to " + t.keepRunning);
    }
}