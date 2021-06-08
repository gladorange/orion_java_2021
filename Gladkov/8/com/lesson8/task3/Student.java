package com.lesson8.task3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student {
    private String name;
    private Set<Lection> lectionSet = new HashSet<>();


    public Student( String name ) {
        this.name = name;
        generateLectionSet();
    }


    public Set<Lection> getLectionSet() {
        return lectionSet;
    }

    public String getName() {
        return name;
    }

    /**
     * Метод генерирующий случайный набор лекций
     */
    private void generateLectionSet(){
        for (int i = 0; i < 5; i++) {
           int pick = new Random().nextInt( Lections.values().length );
           lectionSet.add( new Lection( Lections.values()[pick].getName(),Lections.values()[pick].getDate()) );
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
