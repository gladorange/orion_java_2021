package com.orion.lesson7;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapsExample {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Один", 1);
        map.put("ДВа", 2);
        map.put("ТРИ", 3);


       // System.out.println(map);


        for (String s : map.keySet()) {
            System.out.println(s);

            System.out.println(map.get(s));

        }


        for (Integer s : map.values()) {
            System.out.println(s);
        }


        final Set<Entry<String, Integer>> entries = map.entrySet();

        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " :" + entry.getValue());
        }


        map.put("Один", 24);

        System.out.println(map.containsValue(24));

        System.out.println(map);

        WeakReference<String> weakReference = new WeakReference<>("123123");
        System.gc();

        final String s = weakReference.get();


    }
}
