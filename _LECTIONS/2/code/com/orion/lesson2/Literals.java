package com.orion.lesson2;

public class Literals {


    public static void main(String[] args) {
        int intValue = 42;
        int intBinary = 0b10001;
        int octary = 017;
        System.out.println(octary);


        int hex = 0xFF;

        int big_value = 1_000_000;
        int big_value2 = 1000000;


        Double dValue = 42.;
        Double dValue2 = .5;
        Double dValue3 = 2.5;

        Float flValue = 42.f;


        Double e = 314e-2;

        Long l = 42L;


     //   System.out.println("pi="+e);


        String str = "\u1232";
        System.out.println(str);



        char a = 'E';
        char digit = 65;
        if (a > 'A' && a < 'Z') {
           // System.out.println("Это английская буква БОЛЬШАЯ");
        } else {
          //  System.out.println("Не английская");
        }

        /*
        int day = 08;
        String month = "June";
        int year = 2021;


*/


        String withQuotes = "I'm string \n with \"quote\"";
        System.out.println(withQuotes);



        String multiline = """ 
        kakoi
        to tekst
        """;
        System.out.println(multiline);
    }
}
