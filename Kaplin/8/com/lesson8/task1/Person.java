package com.lesson8.task1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    static List<Person> getPersonList(List<String> names, int startAge, int endAge) {
        return names.stream()
                .map(name -> new Person(name, ThreadLocalRandom.current().nextInt(startAge, endAge)))
                .collect(Collectors.toList());
    }

    static List<Person> sortByName(List<Person> personList,boolean asc) {
        if(!asc) {
            Collections.sort(personList, Comparator.comparing(Person::getName));
        } else {
            Collections.sort(personList, Comparator.comparing(Person::getName).reversed());
        }

        return personList;
    }

    static List<Person> sortByAge(List<Person> personList,boolean asc) {
        if(!asc) {
            Collections.sort(personList, Comparator.comparing(Person::getAge));
        } else {
            Collections.sort(personList, Comparator.comparing(Person::getAge).reversed());
        }

        return personList;
    }

}
