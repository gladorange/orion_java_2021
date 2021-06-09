package com.lesson8.task3;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class DeanOffice {
    private Set<Lection> baseLections;

    public DeanOffice() {
        baseLections = createLections();
    }

    public Set<Lection> getBaseLections() {
        return baseLections;
    }

    private Set<Lection> createLections() {
        List<String> lectionNames = List.of("Математика","Физика","Литература","Матанализ", "Английский язык"
                                            ,"Политология","Философия","Культурология","Биология", "Химия");
        Set<Lection> lections = new HashSet<>();
        lectionNames.forEach(name -> lections.add(new Lection(name, getRandomDate())));
        return lections;
    }
    private LocalDate getRandomDate() {
        return LocalDate.of(2021, 2, ThreadLocalRandom.current().nextInt(1, 5));
    }

    public void showStudentsByLection(List<Student> students, String lectionName) {
        List<Student> list = students.stream()
                .filter(student -> student.getLections()
                        .stream()
                        .anyMatch(lection -> lection.getName().equals(lectionName)))
                .collect(toList());
        System.out.printf("Cписок студентов, которые хоть раз посещали %s%n", lectionName);
        System.out.println(list);
    }
    public void showStudentsLectionCount(List<Student> students) {
        Map<String, Integer> groupByLectionCount = students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(student -> student.getLections().size())));
        System.out.println("Cписок студентов c количеством посещений");
        System.out.println(groupByLectionCount);
    }

    public void showMaxLectionCount(List<Student> students) {
        List<Lection> lections = students.stream()
                .map(Student::getLections)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Map<String, Long> lectionWithMaxCount = lections.stream()
                .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()));

        Long maxCount = Collections.max(lectionWithMaxCount.values());

        lectionWithMaxCount = lectionWithMaxCount.entrySet().stream()
                .filter(lection -> lection.getValue().equals(maxCount))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Cписок лекций c максимальным количеством посещений");
        System.out.println(lectionWithMaxCount);
    }

    public void showStudentsWithMaxLectionsPerDay(List<Student> students) {
        Map<String, Long> studentsWithMaxLectionsPerDay = students.stream()
                .collect(Collectors.toMap(Student::getName, student -> student.getLections()
                        .stream()
                        .collect(Collectors.groupingBy(Lection::getDate, Collectors.counting()))
                        .values()
                        .stream()
                        .max(Long::compare)
                        .orElse(0L)

                ));
        Long maxCount = Collections.max(studentsWithMaxLectionsPerDay.values());

        studentsWithMaxLectionsPerDay = studentsWithMaxLectionsPerDay
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxCount))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("Студент с наибольши количеством посещений за день");
        System.out.println(studentsWithMaxLectionsPerDay);

    }

    public void showStaticsticByLections(List<Student> students) {
        Map<String, List<String>> lectionsWithStudents = students.stream()
                .map(Student::getLections)
                .flatMap(Collection::stream)
                .map(Lection::getName)
                .distinct()
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.toMap(name -> name, name -> getDistinctStudentsForLection(students, name)));

        System.out.println(lectionsWithStudents);

    }

    private List<String> getDistinctStudentsForLection(List<Student> students, String lectionName) {
        return students.stream()
        .collect(Collectors.toMap(Student::getName, student -> student.getLections()
                .stream()
                .map(Lection::getName)
                .collect(Collectors.toList())
        ))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue().contains(lectionName))
        .map(Map.Entry::getKey)
        .distinct()
        .collect(Collectors.toList());
    }

}
