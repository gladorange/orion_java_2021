package com.lesson8.task3;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private String name;
    private Set<Lection> lections;

    public Student(String name, Set<Lection> lections) {
        this.name = name;
        this.lections = goToLections(lections);
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    private Set<Lection> goToLections(Set<Lection> lectionsFromDean) {
        List<Lection> copyForGo = new ArrayList<>(lectionsFromDean);
        Set<Lection> studentLections = new HashSet<>();
        int maxCount = ThreadLocalRandom.current().nextInt(0, lectionsFromDean.size());
        for (int i = 0; i < maxCount; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, copyForGo.size());
            studentLections.add(copyForGo.get(randomIndex));
            copyForGo.remove(randomIndex);
        }
        return studentLections;
    }

    @Override
    public String toString() {
        return "Студент " + name;
    }
}
