package com.orion.lesson2;

public class BreakExternalLoop {


    public static void main(String[] args) {
        String[] strings = {"One", "Two", "Three"};



        outer:
        for (String string : strings) {
            for (char c : string.toCharArray()) {
                if (c == 'T') {
                    System.out.println("Нашли T");
                    break outer;
                }
            }
        }


    }
}
