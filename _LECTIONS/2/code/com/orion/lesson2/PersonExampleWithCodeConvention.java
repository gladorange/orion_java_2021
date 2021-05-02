package com.orion.lesson2;

public class PersonExampleWithCodeConvention {

    public static final String DEFAULT_PERSON_NAME = "Vasya";

    static int personCount = 0;

    String name;

    public PersonExampleWithCodeConvention(String name) {
        this.name = name;
    }

    void sayHello() {
        System.out.println("Hello, I'm " + name);
    }
}
