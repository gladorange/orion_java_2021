package com.orion.java.hw7;

import java.util.List;

public class StringBoxUtils extends Box {

    public static Box<? extends CharSequence> join(List<Box<? extends CharSequence>> list) {
        StringBuilder result = new StringBuilder();
        for (Box box : list) {
            result.append(box.get());
        }
        return Box.of(result);
    }

    public static Box<? extends CharSequence> join(Box<? extends CharSequence> ... arg) {
        StringBuilder result = new StringBuilder();
        for (Box box : arg) {
            result.append(box.get());
        }
        return Box.of(result);
    }

    public static void copyNonEmptyStringBoxToList(Box<? extends CharSequence> box, List<? super CharSequence> list) {
        if (!box.get().toString().isBlank()) {
            list.add(box.get());
        }
    }
}

