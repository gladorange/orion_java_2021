package com.orion.java.homework8;

import com.orion.java.homework8.calculator.Calculator;
import com.orion.java.homework8.univercity.Lecture;
import com.orion.java.homework8.univercity.Lectures;
import com.orion.java.homework8.univercity.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * Точка входа в приложение
     * @param args
     *
     * Тестирование работы калькулятора представлено в классе CalculatorTest.
     */
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Мария", 18),
                new Person("Екатерина", 19),
                new Person("Ильнур", 22),
                new Person("Владимир", 17),
                new Person("Карина", 16),
                new Person("Ольга", 25),
                new Person("Инна", 18)
        ));

        System.out.println("----Сортировка по имени-----");
        Collections.sort( personList, Comparator.comparing(Person::getName) );
        System.out.println(personList);
        System.out.println("----end-----");

        System.out.println("Сортировка по возрасту");
        Collections.sort( personList, Comparator.comparing(Person::getAge) );
        System.out.println( personList );
        System.out.println("----end-----");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Мария"),
                new Student("Екатерина"),
                new Student("Ильнур"),
                new Student("Владимир"),
                new Student("Карина"),
                new Student("Ольга"),
                new Student("Инна")
        ));


        List<Student> mathStudents = students.stream().filter(
                student -> student.getLectures().stream()
                        .anyMatch(
                                lecture -> "Матанализ".equals(lecture.getName())
                        )
        ).collect(Collectors.toList());
        System.out.println(mathStudents);

        System.out.println("--Статистика посещений для каждого студента--- ");
        students.forEach(student -> System.out.println(student.getName() + " " + student.getLectures().size()));
        System.out.println("----end-----");

        System.out.println("---Лекции с наибольшим количеством посещений---");

        Map<String, Integer> visitingNumberAndLectures = new HashMap<>();
        for (Lectures lecture : Lectures.values()) {
            visitingNumberAndLectures.put(lecture.getName(), 0);
        }

        students.stream()
                .flatMap(student -> student.getLectures().stream())
                .forEach(lecture -> visitingNumberAndLectures.put(lecture.getName(), visitingNumberAndLectures.get(lecture.getName()) + 1));

        int maxValue = Collections.max(visitingNumberAndLectures.values());
        visitingNumberAndLectures.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .forEach(entry -> System.out.println(entry.getKey() + ". Количество посещений: " + entry.getValue()));
        System.out.println("--end--");
        System.out.println("---Студенты,посетившие наибольшее количество лекций в день---");
        Map<String, Long> studentsAndMaxVisitedLectures = new HashMap<>();

        for ( Student student : students ) {
            Map<LocalDate, Long> dateAndCount = student
                    .getLectures()
                    .stream()
                    .collect(Collectors.groupingBy( Lecture::getDate, Collectors.counting()));

            Long max = Collections.max(dateAndCount.entrySet(), Map.Entry.comparingByValue()).getValue();
            studentsAndMaxVisitedLectures.put(student.getName(), max);
        }

        Long maxVal = Collections.max( studentsAndMaxVisitedLectures.entrySet(), Map.Entry.comparingByValue() ).getValue();

        studentsAndMaxVisitedLectures.entrySet()
                .stream()
                .filter( entry -> entry.getValue().equals( maxVal ))
                .forEach( System.out::println );
        System.out.println("----end-----");

        System.out.println("---Статистика по курсам----");
        Map<String, Set<String>> cursesAndStatistic = new HashMap<>();

        for ( Lectures lecture : Lectures.values() ) {
            Set<String> names = new HashSet<>();
            for ( Student student : students ) {
                long count = student.getLectures().stream()
                        .filter( l -> l.getName().equals( lecture.getName()) )
                        .count();
                if ( count > 0 ) {
                    names.add(student.getName());
                    cursesAndStatistic.put( lecture.getName(), names );
                }
            }
        }

        System.out.println( cursesAndStatistic );
        System.out.println("----end-----");
    }
}

