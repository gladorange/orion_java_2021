package com.orion.java.hw7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Integer> firstBox = Box.of(2);
        Box<Long> secondBox = Box.of(2L);
        NumberBox third = NumberBox.of(2);
        NumberBox result = third.add(secondBox).multiply(firstBox);
        System.out.println(result.get());

        NumberBox a = NumberBox.of(21);
        NumberBox b = NumberBox.of(0.5);
        NumberBox c = NumberBox.of(2.5);
        NumberBox d = NumberBox.of(100);
        result = a.multiply(b).add((c.multiply(d)));
        System.out.println(result.get());

        List<CharSequence> emptyList = new ArrayList<>();
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of("    "), emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of("сорок два"), emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(Box.of(new StringBuilder("some value ")), emptyList);

        for (CharSequence charSequence : emptyList) {
            System.out.println(charSequence);
        }
        List<Box<? extends CharSequence>> list = new ArrayList<>();
        list.add(Box.of("b1 "));
        list.add(Box.of("b2 "));
        list.add(Box.of("b3 "));
        list.add(Box.of("b4"));

        System.out.println(StringBoxUtils.join(list).get());

        Box box = StringBoxUtils.join(Box.of("b11 "),Box.of("b22 "),Box.of("b33 "),Box.of("b44 "));
        System.out.println(box.get());
    }
}
