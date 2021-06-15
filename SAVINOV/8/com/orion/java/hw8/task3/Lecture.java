package com.orion.java.hw8.task3;

import java.time.LocalDate;

public class Lecture {
    private String lectureName;
    private LocalDate dateOfStart;

    public Lecture(String lectureName, LocalDate dateOfStart) {
        this.lectureName = lectureName;
        this.dateOfStart = dateOfStart;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    @Override
    public String toString() {
        return lectureName + " - " + dateOfStart;
    }
}