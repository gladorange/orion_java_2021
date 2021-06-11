package com.task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task1 {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public static Person of(String name, int age) {
            return new Person(name, age);
        }

        @Override
        public String toString() {
            return String.format("%s %d лет", name, age);
        }
    }

    public static void run() {
        List<Person> people = new ArrayList<>(List.of(
                Person.of("Вася", 20),
                Person.of("Алекс", 20),
                Person.of("Яша", 20),
                Person.of("Петя", 26),
                Person.of("Маша", 26),
                Person.of("Иван", 35),
                Person.of("Петя", 27),
                Person.of("Соня", 18),
                Person.of("Валя", 16),
                Person.of("Дима", 28)
        ));
        System.out.println("Список людей:                        " + people);
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("Отсортированные по имени:            " + people);
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Отсортированные по имени и возрасту: " + people);
    }

}
