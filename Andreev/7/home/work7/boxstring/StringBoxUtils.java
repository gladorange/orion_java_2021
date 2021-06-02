package home.work7.boxstring;


import home.work7.boxnumber.Box;

import java.util.List;

public class StringBoxUtils {

    public static Box<CharSequence> join(Box<CharSequence> ... boxes){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<boxes.length;i++){
            sb.append(boxes[i].getValue().toString()).append(" ");
        }
        return new Box<>(sb);
    }

    public static Box<CharSequence> join(List<Box<CharSequence>> boxes){
        StringBuilder sb = new StringBuilder();
        for (Box<CharSequence> el : boxes){
            sb.append(el.getValue().toString()).append(" ");
        }
        return new Box<>(sb);
    }

    public static <T extends CharSequence> void copyNonEmptyStringBoxToList(Box<T> box, List<T> list){
        if (box.getValue().toString().trim().length()!=0){
            list.add(box.getValue());
        }
    }


}
