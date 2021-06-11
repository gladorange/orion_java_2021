package com.orion.lesson9;

public class ThreadLocalExample {


    static class Counter {

        static int counter = 0;
        String name;

        public Counter() {
            synchronized (Counter.class) {
                this.name = "Счетчик " + counter++;
            }
        }

        public String getName() {
            return name;
        }
    }


    static ThreadLocal<Counter> counterHolder = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable counter = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (counterHolder.get() == null) {
                        final Counter value = new Counter();
                        counterHolder.set(value);
                    }

                    System.out.println(counterHolder.get().getName());
                }

            }
        };


        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(counter);
            t.start();
        }


        System.out.println("Main");
    }


}
