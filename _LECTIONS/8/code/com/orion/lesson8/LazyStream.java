package com.orion.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LazyStream {


    public static void main(String[] args) {


        List<String> strings = new ArrayList<>(List.of("A", "C", "B"));

        Stream<String> stream = strings.stream();

        stream
                .sorted()
                .filter(str -> !str.equals("A"))
                .forEach(System.out::println);


        strings.removeIf(str -> str.equals("C"));


    }
}
