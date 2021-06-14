package com.orion.java.hw8.task3;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Lecture {
    private String nameOfLecture;
    private LocalDate dateOfStart;

    public Lecture(String nameOfLecture, LocalDate dateOfStart) {
        this.nameOfLecture = nameOfLecture;
        this.dateOfStart = dateOfStart;
    }

    public String getNameOfLecture() {
        return nameOfLecture;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    @Override
    public String toString() {
        return nameOfLecture + " - " + dateOfStart;
    }
}
