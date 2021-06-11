package com.orion.lesson11;

import java.util.ArrayList;
import java.util.List;

public class GenericBadExample {


    public static void main(String[] args) {


        List<Integer> integers = new ArrayList<>();
        integers.add(42);
       // doNothing(integers, 42L);

    }


    public static <T extends Number> void doNothing(List<T> list, T anotherVariable) {
        final T number = list.get(0);
        list.set(0, number);
        list.add(anotherVariable);
    }
}
