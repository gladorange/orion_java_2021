package com.orion.lesson8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparators {

    static class Animal {
        String name;
        Integer age;

        public Animal(String name, Integer age) {
            this.name = name;
            this.age = age;
        }


        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public static void main(String[] args) {
        final List<Animal> animals = new ArrayList<>(List.of(
                new Animal("Васька", 5),
                new Animal("Машка", 5),
                new Animal("Петька", 5),
                new Animal("Абрикоc", 5),
                new Animal("Борис", 6)

        ));




        Collections.sort(animals, Comparator
                .comparing((Animal animal) -> animal.getAge())
                .thenComparing((Animal animal) -> animal.getName()));
        System.out.println(animals);

    }

}
