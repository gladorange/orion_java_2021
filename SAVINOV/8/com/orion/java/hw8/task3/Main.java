package com.orion.java.hw8.task3;

import java.util.*;

import static java.util.List.*;

public class Main {
    public static void main(String[] args) {
        List<String> lectures = List.of("матанализ", "философия", "английский язык", "история", "физкультура");

        List<Student> students = of(
                new Student("Вася", lectures),
                new Student("Петя", lectures),
                new Student("Маша", lectures),
                new Student("Саша", lectures),
                new Student("Даша", lectures),
                new Student("Глаша", lectures),
                new Student("Вика", lectures),
                new Student("Тася", lectures),
                new Student("Ася", lectures),
                new Student("Галя", lectures)
        );
        System.out.println(students);

        Work.runTask1(students);
        Work.runTask2(students);
        Work.runTask3(students);
        Work.runTask4(students);
        Work.runTask5(students);
    }
}
