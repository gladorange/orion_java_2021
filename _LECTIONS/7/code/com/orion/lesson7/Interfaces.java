package com.orion.lesson7;

import java.util.Collections;
import java.util.List;

public class Interfaces {



    static abstract class Person {
        public Person(String name) {
            this.name = name;
        }

        String name;

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    static class PersonWithLastName extends Person {
        String lastname;

        public PersonWithLastName(String name, String lastname) {
            super(name);
            this.lastname = lastname;
        }
    }

    static class ComparablePerson extends Person implements Comparable<ComparablePerson> {

        int money;

        public ComparablePerson(String name,int money) {
            super(name);
            this.name = name;
            this.money = money;
        }

        @Override
        public int compareTo(ComparablePerson o) {
            return money - o.money;
        }
    }

    static class ComparablePersonWithLastName extends PersonWithLastName implements Comparable<ComparablePersonWithLastName> {

        public ComparablePersonWithLastName(String name,String lastname) {
            super(name, lastname);
        }

        @Override
        public int compareTo(ComparablePersonWithLastName o) {
            return lastname.compareTo(o.lastname);
        }
    }


    public static void main(String[] args) {


        List<ComparablePersonWithLastName> lastNames = List.of(
                new ComparablePersonWithLastName("2", "Петров"),
                new ComparablePersonWithLastName("1", "Андреев")
        );

        List<ComparablePerson> monay = List.of(
                new ComparablePerson("1", 0),
                new ComparablePerson("2", 100)
        );

        sortPersons(lastNames);
        sortPersons(monay);

    }


    public static <T extends Person & Comparable<T>> void sortPersons(List<T> persons) {
        final T max = Collections.max(persons);
        System.out.println(max.getName());

    }
}
