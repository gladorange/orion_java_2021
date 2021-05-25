package com.orion.lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeAndCompute {



    static class Person {
        String name;
        String profession;


        @Override
        public String toString() {
            return name;
        }

        public String getName() {
            return name;
        }

        public String getProfession() {
            return profession;
        }

        public Person(String name, String profession) {
            this.name = name;
            this.profession = profession;
        }
    }

    public static void main(String[] args) {

        final List<Person> people = List.of(
                new Person("Вася", "Программист"),
                new Person("Петя", "Программист"),
                new Person("Маша", "Программист"),
                new Person("Иван", "Тестировщик")
        );


        Map<String, List<Person>> result =new HashMap<>();

        for (Person person : people) {
/*
            if (!result.containsKey(person.profession)) {
                result.put(person.profession, new ArrayList<>());
            }

            result.get(person.profession).add(person);

            */
            result
                    .computeIfAbsent(person.profession, key -> new ArrayList<>())
                    .add(person);
        }



        System.out.println(result);


        final Map<String, List<Person>> collect = people
                .stream()
                .collect(Collectors.groupingBy(person -> person.profession));

        System.out.println(collect);

    }
}
