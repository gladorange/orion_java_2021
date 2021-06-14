package com.orion.java.hw8.task3;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private String nameOfStudent;
    private Set<Lecture> lectures;

    public Student(String nameOfStudent, List<String> listOfLecture) {
        this.nameOfStudent = nameOfStudent;
        this.lectures = getLecturesSet(listOfLecture);
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public Set<Lecture> getListOfLecture() {
        return lectures;
    }

    @Override
    public String toString() {
        return nameOfStudent + "," + lectures + "\n";
    }

    private Set<Lecture> getLecturesSet(List<String> lectures) {
        Set<Lecture> finalListLectures = new HashSet<>();
        for (String lecture : lectures) {
            if (new Random().nextBoolean()) {
                finalListLectures.add(new Lecture(lecture, getDateOfLecture(2021, Month.MAY)));
            }
        }
        return finalListLectures;
    }

    private LocalDate getDateOfLecture(int year, Month month){
        return LocalDate.of(year, month, getRandomDayOfMonth(month));
    }

    private int getRandomDayOfMonth(Month month){
        return ThreadLocalRandom.current().nextInt(1, month.maxLength());
    }
}
