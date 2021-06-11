package com.task7.Boxes;


import java.util.ArrayList;
import java.util.List;

public class StringBoxUtils {
    public static Box<String> join(Box<? extends CharSequence>... stringsBoxes) {
        StringBuilder res = new StringBuilder();
        for (Box<? extends CharSequence> box : stringsBoxes) {
            res.append(box.get().toString());
        }
        return Box.of(res.toString());
    }

    public static void copyNonEmptyStringBoxToList(Box<? extends CharSequence> box, List<? super CharSequence> dest) {
        if (box.get().toString().replaceAll(" ", "").length() != 0) {
            dest.add(box.get());
        }
    }

    public static void run() {
        System.out.println("Demo StringBoxUtils.join():");
        Box<String> joinedStr = join(
                Box.of("String 1 "),
                Box.of((CharSequence) "CharSequence 1 "),
                Box.of(new StringBuilder().append("StringBuilder ").append(1).append(" ")));
        System.out.println(joinedStr.get());
        System.out.println();
        System.out.println("Demo StringBoxUtils.copyNonEmptyStringBoxToList():");
        List<CharSequence> emptyList = new ArrayList<>();
        System.out.println("Created emptyList: " + emptyList);
        System.out.println();
        System.out.println("Trying to add Box.of(\"    \")");
        copyNonEmptyStringBoxToList(Box.of("    "), emptyList);
        System.out.println("emptyList: " + emptyList);
        System.out.println();
        System.out.println("Trying to add Box.of(\"сорок два\")");
        copyNonEmptyStringBoxToList(Box.of("сорок два"), emptyList);
        System.out.println("emptyList: " + emptyList);
        System.out.println();
        System.out.println("Trying to add Box.of(new StringBuilder(\"some value \"))");
        copyNonEmptyStringBoxToList(Box.of(new StringBuilder("some value")), emptyList);
        System.out.println("emptyList: " + emptyList);
        System.out.println();
        System.out.println("Add more boxes to list");
        copyNonEmptyStringBoxToList(Box.of("    t "), emptyList);
        copyNonEmptyStringBoxToList(Box.of(""), emptyList);
        copyNonEmptyStringBoxToList(Box.of(new StringBuilder().append("test").append(123)), emptyList);
        copyNonEmptyStringBoxToList(joinedStr, emptyList);
        System.out.println("emptyList: " + emptyList);
    }
}
