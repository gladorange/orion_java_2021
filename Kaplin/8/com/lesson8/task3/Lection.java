package com.lesson8.task3;

import java.time.LocalDate;

public class Lection {
    private String name;
    private LocalDate date;

    public Lection(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
