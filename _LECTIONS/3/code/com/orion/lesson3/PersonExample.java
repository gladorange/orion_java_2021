package com.orion.lesson3;

public class PersonExample {
    final String name;
    String lastName;
    int age;



    /**
     * This is construtor with 3 arguments
     *
     * @param name required
     * @param lastName
     * @param age
     */
    public PersonExample(String name, String lastName, int age) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null");
        }
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }


    public static void main(String[] args) {
        PersonExample person = new PersonExampleBuilder()
                .setName("Vasya")
                .setAge(18)
                .createPersonExample();

        System.out.println(person.name.length());
    }


}
