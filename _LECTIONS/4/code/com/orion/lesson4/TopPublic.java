package com.orion.lesson4;

public class TopPublic {
    public static String CONST = "$@";



    public static void printString() {
        System.out.println(new Helper().getString());
    }



    public static class Helper {
        public String getString() {
            return "String from non public class";
        }
    }


}

