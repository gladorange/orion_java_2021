package com.orion.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaUsages {


    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);


        System.out.println(integers);


        integers.removeIf(integer -> integer % 2 == 0);

        System.out.println(integers);
    }
}
