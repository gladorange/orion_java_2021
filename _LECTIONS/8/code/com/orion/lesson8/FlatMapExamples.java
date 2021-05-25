package com.orion.lesson8;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExamples {



    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return  name;
        }
    }


    public static void main(String[] args) {
        List<Student> group1 = List.of(
                new Student("Вася"),
                new Student("Петя")
                );

        List<Student> group2 = List.of(
                new Student("Маша"),
                new Student("Саша")
                );


        final long numberOfStudents = Stream
                .of(group1, group2)
                .flatMap(Collection::stream)
                .peek(student -> System.out.println(student.name))
                .count();







        System.out.println(numberOfStudents);


    }

}
