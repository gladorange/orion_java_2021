package com.orion.lesson8;

import java.util.function.Function;

public class FunctionChainingExample {


    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        String name = "Vasya";

        Function<String, Person> strToObject = str -> new Person(str);
        Function<Person, Integer> personToNameLength = person -> person.name.length();

        final Function<String, Integer> composedFunction = strToObject.andThen(personToNameLength);

        System.out.println(composedFunction.apply(name));




    }



}
