package com.orion.lesson3;

public class PersonExampleBuilder {
    private String name;
    private String lastName = "";
    private int age = 0;

    public PersonExampleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonExampleBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonExampleBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonExample createPersonExample() {
        return new PersonExample(name, lastName, age);
    }
}