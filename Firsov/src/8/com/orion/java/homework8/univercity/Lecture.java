package com.orion.java.homework8.univercity;

import java.time.LocalDate;
import java.util.Objects;

public class Lecture {
    private String name;
    private LocalDate date;


    public Lecture( String name, LocalDate date ) {
        if(name == null || date == null){
            throw new NullPointerException("Error:Arguments in constructor can't be null.");
        }
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(name, ((Lecture)obj).name   ) && Objects.equals(date, ((Lecture)obj).date);
    }

    @Override
    public int hashCode() {
        final int prime = 7;
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
