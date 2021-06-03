package com.lesson8.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DeanOffice deanOffice = new DeanOffice();
        Set<Lection> lections = deanOffice.getBaseLections();

        List<String> names = List.of("Vasya", "Sam", "July", "Chack", "Don", "Anna", "Brendon", "Nikol", "Leo", "Bad");
        List<Student> students = new ArrayList<>();

        for (String name: names) {
            students.add(new Student(name, lections));
        }
        deanOffice.showStudentsByLection(students, "Матанализ");
        deanOffice.showStudentsLectionCount(students);
        deanOffice.showMaxLectionCount(students);
        deanOffice.showStudentsWithMaxLectionsPerDay(students);
        deanOffice.showStaticsticByLections(students);
    }
}
