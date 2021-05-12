package com.orion.lesson4;

public class FinalizeExample {


    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }


        @Override
        protected void finalize() throws Throwable {
            System.out.println(String.format("Человек %s собирается GarbageCollector'ом", name));
        }
    }



    public static void main(String[] args) {


        Person вася = new Person("Вася");
        System.out.println(вася.name);
        вася = null;
        System.gc();
        System.out.println("Конец программы");


    }
}
