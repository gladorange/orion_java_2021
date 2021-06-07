package com.lesson8.task1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Person.getPersonList(List.of("Vasya", "Sam", "July", "Chack", "Don", "Anna", "Brendon"), 5, 55);
        System.out.println(Person.sortByName(persons, false));
        System.out.println(Person.sortByName(persons, true));
        System.out.println(Person.sortByAge(persons, false));
        System.out.println(Person.sortByAge(persons, true));
    }
}
