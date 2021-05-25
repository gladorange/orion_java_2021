package home.work7.boxstring;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<CharSequence> emptyList = new ArrayList<>();
        Box<CharSequence> box1 = new Box<>("   ");
        Box<CharSequence> box2 = new Box<>("сорок два");
        Box<CharSequence> box3 = new Box<>(new StringBuilder("some value "));
        StringBoxUtils.copyNonEmptyStringBoxToList(box1, emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(box2, emptyList);
        StringBoxUtils.copyNonEmptyStringBoxToList(box3, emptyList);
        System.out.println(emptyList);

        System.out.println(StringBoxUtils.join(box1,box2,box3).getValue().toString().trim());

        List<Box<CharSequence>> list = new ArrayList<>();
        list.add(box1);
        list.add(box2);
        list.add(box3);
        System.out.println(StringBoxUtils.join(list).getValue().toString().trim());
    }
}
