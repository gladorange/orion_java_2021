package com.orion.java.hw8.task3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Work {

    public static void runTask1(List<Student> students) {
        List<Student> result = students.stream()
                .filter(student -> student.getLectures()
                        .stream().anyMatch(lecture -> lecture.getLectureName().equals("матанализ")))
                .collect(Collectors.toList());
        printLineSeparator();
        System.out.println("Студенты, хоть раз посещавшие матанализ:");
        System.out.println(result);
    }

    public static void runTask2(List<Student> students) {
        printLineSeparator();
        System.out.println("Посещаемость по студентам:");
        students.forEach(student -> System.out.println(student.getStudentName() + " - " + student.getLectures().size()));
    }

    public static void runTask3(List<Student> students) {
        Map<String, Long> mapLecturesCount = students.stream()
                .flatMap(student -> student.getLectures().stream())
                .collect(Collectors.groupingBy(Lecture::getLectureName, Collectors.counting()));

        Long maxValueInMap = Collections.max(mapLecturesCount.values());
        printLineSeparator();
        System.out.println("Наибольшее количество лекций:");
        mapLecturesCount.entrySet()
                .stream()
                .filter(lecture -> lecture.getValue() == maxValueInMap)
                .forEach(System.out::println);
    }

    public static void runTask4(List<Student> students) {
        Map<String, Long> mapMaxLectureVisits = students.stream()
                .collect(Collectors.toMap(Student::getStudentName, student -> student.getLectures().stream()
                        .collect(Collectors.groupingBy(Lecture::getDateOfStart, Collectors.counting()))
                        .values().stream()
                        .max(Long::compareTo)
                        .orElse(0L)));

        Long maxValueInMap2 = Collections.max(mapMaxLectureVisits.values());
        printLineSeparator();
        System.out.println("Наибольшее количество посещений лекций:");
        mapMaxLectureVisits.entrySet()
                .stream()
                .filter(pair -> pair.getValue() == maxValueInMap2)
                .forEach(System.out::println);
    }

    public static void runTask5(List<Student> students) {
        Map<String, List<String>> mapStudentListLectures = students.stream()
                .collect((Collectors.toMap(Student::getStudentName, student -> student.getLectures()
                        .stream()
                        .map(Lecture::getLectureName)
                        .distinct()
                        .collect(Collectors.toList()))));

        Map<String, Long> mapCountLectures = mapStudentListLectures.entrySet().stream()
                .flatMap(student -> student.getValue().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        printLineSeparator();
        System.out.println("Статистика по курсам:");
        System.out.println(mapCountLectures);
    }

    private static void printLineSeparator(){
        System.out.println();
        System.out.println("   ********");
        System.out.println();
    }
}