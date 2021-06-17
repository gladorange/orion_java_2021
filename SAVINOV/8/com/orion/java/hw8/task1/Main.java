package com.orion.java.hw8.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Евгений", 18),
                new Person("Дмитрий", 22),
                new Person("Александр", 28),
                new Person("Андрей", 32),
                new Person("Никита", 30)
        ));

        Comparator<Person> comparatorName = Comparator.comparing(Person::getName);
        Collections.sort(people,comparatorName);
        System.out.println(people);

        Comparator<Person> comparatorAge = Comparator.comparing(Person::getAge);
        Collections.sort(people, comparatorAge);
        System.out.println(people);
    }
}
