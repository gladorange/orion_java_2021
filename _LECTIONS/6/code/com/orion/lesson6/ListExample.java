package com.orion.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListExample {


    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        list.add(42);

        System.out.println("Размер массива" + list.size());
        list.add(54);
        list.add(null);
        System.out.println("Размер массива" + list.size());

        System.out.println(list);

        final Integer[] integers = list.toArray(new Integer[0]);

        System.out.println(Arrays.toString(integers));


        Integer[] ints = new Integer[10];
        System.out.println(ints.length);
        System.out.println(Arrays.toString(ints));


    }
}
