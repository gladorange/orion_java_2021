package com.orion.java.homework7;

import java.util.ArrayList;
import java.util.List;

import static com.orion.java.homework7.StringBoxUtils.copyNonEmptyStringBoxToList;


public class Main {
    /**
     * Точка входа в приложение.
     * @param args
     */
    public static void main(String[] args) {

        Box<Float> firstBox = Box.of(1.3f);
        Box<Long> secondBox = Box.of(2L);
        NumberBox third = NumberBox.of(3);
        System.out.println( third.add(secondBox).multiply(firstBox).getValue() );

        List<CharSequence> emptyList = new ArrayList<>();
        copyNonEmptyStringBoxToList(Box.of("     "), emptyList); // пустая строка не должна добавиться
        System.out.println("emptyList |"+emptyList+"|");
        copyNonEmptyStringBoxToList(Box.of("сорок два"), emptyList); // теперь внутри emptyList лежит "сорок два"
        System.out.println("emptyList |"+emptyList+"|");
        copyNonEmptyStringBoxToList(Box.of(new StringBuilder("some value ")), emptyList); // теперь внутри emptyList лежит "сорок два" и "some value"
        System.out.println("emptyList |"+emptyList+"|");

        List<String> stringList = new ArrayList<>();
        copyNonEmptyStringBoxToList(Box.of("     "), stringList);  // пустая строка не должна добавиться
        System.out.println("stringList |"+stringList+"|");
        copyNonEmptyStringBoxToList(Box.of("сорок два"), stringList);
        System.out.println("stringList |"+stringList+"|");
     //   copyNonEmptyStringBoxToList(Box.of(new StringBuilder("some value ")), stringList); Ошибка компиляции

        System.out.println( StringBoxUtils.join(Box.of("|Ты|_"),Box.of("|и|"),Box.of("_|Я|.")).getValue() );

        List<Box<? extends CharSequence>> boxesList = new ArrayList<>();
        boxesList.add(Box.of("|Ты|"));
        boxesList.add(Box.of("_|и|"));
        boxesList.add(Box.of("_|Я|."));
        System.out.println( StringBoxUtils.join( boxesList ).getValue() );


    }
}
