package com.orion.java.hw8.task3;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private String studentName;
    private Set<Lecture> lectures;

    public Student(String studentName, List<String> listOfLecture) {
        this.studentName = studentName;
        this.lectures = generateLectures(listOfLecture);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public String toString() {
        return studentName + " - " + lectures + "\n";
    }

    private Set<Lecture> generateLectures(List<String> lectures) {
        Set<Lecture> finalListLectures = new HashSet<>();
        for (String lecture : lectures) {
            if (new Random().nextBoolean()) {
                finalListLectures.add(new Lecture(lecture, getDateOfLecture(2021, Month.MAY)));
            }
        }
        return finalListLectures;
    }

    private LocalDate getDateOfLecture(int year, Month month) {
        return LocalDate.of(year, month, getRandomDayOfMonth(month));
    }

    private int getRandomDayOfMonth(Month month) {
        return ThreadLocalRandom.current().nextInt(1, 3);//month.maxLength());
    }
}
