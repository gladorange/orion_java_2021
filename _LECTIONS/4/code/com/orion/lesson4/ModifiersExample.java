package com.orion.lesson4;

public class ModifiersExample {


    public static void main(String[] args) {


        final PersonWithModifiers personWithModifiers = new PersonWithModifiers("Вася", "Иванов");
        System.out.println(personWithModifiers.getName());
        System.out.println(personWithModifiers.getSurname());
        System.out.println(personWithModifiers.getPassword());
    }
}
