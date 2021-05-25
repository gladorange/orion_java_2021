package com.orion.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListExample {


    public static void main(String[] args) {
       /* List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);


        for (Integer integer : arrayList) {
            if (integer==3) {
                arrayList.add(33);
            }
        }

        System.out.println(arrayList);

        */

        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);


        for (Integer integer : copyOnWriteArrayList) {
            if (integer==3) {
                copyOnWriteArrayList.add(33);
            }
        }


        copyOnWriteArrayList.removeIf(integer -> integer % 2 == 0);


        System.out.println(copyOnWriteArrayList);
    }
}
