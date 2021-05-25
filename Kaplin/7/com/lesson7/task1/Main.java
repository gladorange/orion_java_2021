package com.lesson7.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Box<Integer> firstBox = Box.of(2);
        Box<Long> secondBox = Box.of(2L);
        NumberBox thirdBox = NumberBox.of(2.8);
        NumberBox fourBox = NumberBox.of(2.1);
        System.out.println( thirdBox.add(secondBox).add(firstBox).getValue());
        System.out.println( thirdBox.add(secondBox).multiply(firstBox).add(fourBox).getValue());

        System.out.println(StringBoxUtils.join(List.of(Box.of("Боксы ")
                , Box.of("складываются, ")
                , Box.of("но стримы в Java плсе JS выглядят несколько путанно")) ).getValue());

        List<CharSequence> emptyList = new ArrayList<>();
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of("    "), emptyList); // пустая строка не должна добавиться
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of("сорок два"), emptyList); // теперь внутри emptyList лежит "сорок два"
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of(new StringBuilder("some value ")), emptyList); // теперь внутри emptyList лежит "сорок два" и "some value"
        System.out.println(emptyList);
    }
}
