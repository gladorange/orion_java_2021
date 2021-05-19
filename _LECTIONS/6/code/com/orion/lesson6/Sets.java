package com.orion.lesson6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {



    static class PersonWithName implements Comparable<PersonWithName> {
        String name;

        public PersonWithName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(PersonWithName o) {
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "PersonWithName{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();

        strings.add("x");
        strings.add("y");
        strings.add("z");
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("c");
        strings.add("c");
        strings.add("c");
        strings.add("c");
        strings.add("c");
        strings.add("c");
        strings.add("c");
        strings.add("c");


        System.out.println(strings);


        Set<String> treeNames = new TreeSet<>();
        treeNames.add("Petya");
        treeNames.add("Petya");
        treeNames.add("Petya");
        treeNames.add("Petya");
        treeNames.add("Vasya");
        treeNames.add("Anna");


        System.out.println(treeNames);


        final Comparator<PersonWithName> personWithNameComparator = Comparator.comparing(p -> p.name);

        Set<PersonWithName> persons = new TreeSet<>(personWithNameComparator.reversed());

        persons.add(new PersonWithName("Vasya"));
        persons.add(new PersonWithName("Petya"));

        System.out.println(persons);


    }
}
