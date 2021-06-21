package com.orion.java.homework8.univercity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student {
    private String name;
    private Set<Lecture> lectures = new HashSet<>();


    public Student( String name ) {
        this.name = name;
        generateRandomLectures();
    }

    public String getName() {
        return name;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    private void generateRandomLectures(){
        for (int i = 0; i < 5; i++) {
            int pick = new Random().nextInt( Lectures.values().length );

            lectures.add( new Lecture( Lectures.values()[pick].getName(),Lectures.values()[pick].getDate()) );
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
