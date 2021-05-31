package com.lesson7;

import com.lesson7.task1.NumberBox;
import com.lesson7.task2.StringBoxUtils;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        System.out.println(" /**********Задача с цифрами*******************/ ");
        Box<Integer> firstBox = Box.of(1);
        Box<Long> secondBox = Box.of(2L);
        NumberBox third = NumberBox.of(3);
        System.out.println( third.add(secondBox).multiply(firstBox).get() );
        NumberBox one = NumberBox.of(1);
        NumberBox another = NumberBox.of(2);
        System.out.println(one.add(another).get());


        System.out.println(" /**********Задача с буквами*******************/ ");
        List<CharSequence> emptyList = new ArrayList<>();
        StringBoxUtils.copyNonEmptyStringBoxToList( Box.of("    "), emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of("сорок два"), emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of(new StringBuilder("some value ")), emptyList);
        System.out.println( emptyList );

        System.out.println( StringBoxUtils.join(Box.of("One "),Box.of("Two "),Box.of("Three")).get() );
        List<Box<? extends CharSequence>> listBox = new ArrayList<>();
        listBox.add(Box.of("Four "));
        listBox.add(Box.of("Five "));
        listBox.add(Box.of("Six "));
        System.out.println( StringBoxUtils.join( listBox ).get() );
    }
}
