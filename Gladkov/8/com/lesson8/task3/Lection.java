package com.lesson8.task3;

import java.time.LocalDate;
import java.util.Objects;

public class Lection {
    private String name;
    private LocalDate date;


    public Lection( String name, LocalDate date ) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lection lection = (Lection) o;
        return Objects.equals(name, lection.name) && Objects.equals(date, lection.date);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "name='" + name + '\'' +
                '}';
    }
}
