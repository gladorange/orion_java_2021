package com.orion.java.lesson1;

public class Person {

    static int count = 0;
    String name;


    void printName() {
        printName("Privet");
    }


    void printName(String greeting) {
        System.out.println( greeting + ", ya " + name);
    }


    public static void main(String[] args) {

        Person vasya = new Person();
        vasya.name = "Вася";

        vasya.printName();
        vasya.printName("Привет");

    }

}
