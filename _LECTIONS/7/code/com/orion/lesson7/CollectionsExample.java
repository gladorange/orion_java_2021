package com.orion.lesson7;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CollectionsExample {


    public static void main(String[] args) {
        printString(Collections.singleton("asdr"));
        addElementToList(Collections.singletonList("50"));
    }


    static void printString(Set<String> stringsToPrint) {
        for (String s : stringsToPrint) {
            System.out.println(s);
        }
    }
    static void addElementToList(List<String> stringsToPrint) {
        stringsToPrint.add("42");
    }
}
