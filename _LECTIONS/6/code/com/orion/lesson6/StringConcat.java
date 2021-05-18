package com.orion.lesson6;

public class StringConcat {


    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            str.append(i).append(" ");
        }

        System.out.println(str.toString());
    }
}
