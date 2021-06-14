package com.orion.java.hw8.task3;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.List.*;

public class Main {
    public static void main(String[] args) {
        List<String> lectures = List.of("матанализ", "философия", "английкий язык", "история", "физкультура");

        List<Student> students = of(
                new Student("Вася", lectures),
                new Student("Петя", lectures),
                new Student("Маша", lectures),
                new Student("Саша", lectures),
                new Student("Даша", lectures),
                new Student("Глаша", lectures),
                new Student("Каша", lectures),
                new Student("Тася", lectures),
                new Student("Ася", lectures),
                new Student("Галя", lectures)
        );
        System.out.println(students);

        /*
        List<Student> matan = new ArrayList<>();
        for (Student student : students) {
            for (Lecture lecture : student.getListOfLecture()) {
                if (lecture.getNameOfLecture().equals("матанализ")) {
                    matan.add(student);
                }
            }
        }
        System.out.println(matan);
        */
/*
        List<Student> result = students.stream()
                .filter(student -> student.getListOfLecture()
                        .stream().anyMatch(lecture -> lecture.getNameOfLecture().equals("матанализ")))
                .collect(Collectors.toList());
        System.out.println("Студенты, хоть раз посещавшие матанализ:");
        System.out.println(result);
*/
        /*
        for (Student student : students) {
            System.out.println(student.getNameOfStudent() + " - " + student.getListOfLecture().size());
        }
        */
        /*
        System.out.println("Посещаемость по студентам:");
        students.stream().
                forEach(student -> System.out.println(student.getNameOfStudent() + " - " + student.getListOfLecture().size()));
*/
/*
        Map<String, Integer> stringIntegerMap = new HashMap<>();

        for (Student student : students) {
            for (Lecture lecture : student.getListOfLecture()) {
                stringIntegerMap.merge(lecture.getNameOfLecture(), 1, (eVal,newVal)-> eVal + newVal);
            }
        }
        System.out.println(stringIntegerMap);

        int maxValueInMap = (Collections.max(stringIntegerMap.values()));
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println(entry.getKey());
            }
        }
*/
        /*
        List<Lecture> lectures1 = students.stream()
                .flatMap(student -> student.getListOfLecture().stream())
                .collect(Collectors.toList());

        Map<String, Long> map = lectures1.stream()
                .collect(Collectors.groupingBy(lecture -> lecture.getNameOfLecture(), Collectors.counting()));

        Long maxValueInMap1 = Collections.max(map.values());

        System.out.println("Наибольшее количество лекций");
        map.entrySet()
                .stream()
                .filter(lecture -> lecture.getValue().equals(maxValueInMap1))
                .forEach(System.out::println);
         */

    }

}
