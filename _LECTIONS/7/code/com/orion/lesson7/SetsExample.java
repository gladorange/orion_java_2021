package com.orion.lesson7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class SetsExample {



    static class Person {
        final String name;

        public Person(String name) {
            this.name = name;
            name = "a";

        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {


        TreeSet<Person> set = new TreeSet<>(Comparator.comparing(p -> p.name));
        set.add(new Person("Вася"));
        set.add(new Person("Иоанн"));
        set.add(new Person("Александр"));
        System.out.println(set);


        TreeSet<Person> setOf = new TreeSet<>(Comparator.comparing(p -> p.name.length()));
        setOf.add(new Person("Вася"));
        setOf.add(new Person("Иоанн"));
        setOf.add(new Person("Александр"));
        setOf.add(new Person("Петя"));
        System.out.println(setOf);



    }
}
