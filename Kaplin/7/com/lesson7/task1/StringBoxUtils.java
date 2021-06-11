package com.lesson7.task1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StringBoxUtils {
    public static Box<CharSequence> join(List<Box<CharSequence>> charBoxList) {
        Stream<String> stringStream = charBoxList.stream().map(elem -> elem.getValue().toString());
        Optional<String> sentence = stringStream.reduce((x, y)-> x + y);
        return new Box<>(sentence.orElse(""));
    }

    public static void copyNonEmptyStringBoxToList(Box<CharSequence> sourceBox, List<CharSequence> charSequenceList) {
        boolean notEmpty = !sourceBox.getValue().toString().replaceAll(" ", "").isEmpty();
        if(notEmpty) {
            charSequenceList.add(sourceBox.getValue());
        }
    }
}
