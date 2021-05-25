package com.orion.lesson8;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntegerReduce {


    public static void main(String[] args) {


        List<Integer> ints = List.of(1, 3, 5);


        final Integer result = ints.stream().reduce(0, (sum, nextInt) -> sum += nextInt);

        System.out.println(result);


        List<Integer> anotherInts = List.of(1, 3, 5, 2, 4);



        final Set<Integer> collect = anotherInts
                .stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(collect);

    }
}
