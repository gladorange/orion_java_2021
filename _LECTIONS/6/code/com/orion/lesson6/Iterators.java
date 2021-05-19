package com.orion.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Iterators {


    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Collection<String> linkedList = new LinkedList<>(Arrays.asList("1", "2", "3"));


       // List<String> toAdd = new ArrayList<>();

        for (ListIterator<String> iterator = arrayList.listIterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            System.out.println(s);

            if (s.equals("b")) {
                iterator.add("B");
            }
        }

        System.out.println(arrayList);


        for (ListIterator<String> iterator = arrayList.listIterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            System.out.println(s);

            if (s.equals("b")) {
                iterator.remove();
            }
        }

        System.out.println(arrayList);

        // arrayList.addAll(toAdd);

/*
        for (String s : linkedList) {
            System.out.println(s);
        }*/


    }
}
