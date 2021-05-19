package com.orion.lesson6;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThLoRandom {

    public static void main(String[] args) {

        String str = "Жил был колобок";


        Pattern pattern = Pattern.compile("о");


        final Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("нашли о");
            System.out.println("start:" + matcher.start());
            System.out.println("end:" + matcher.end());
        }


        final String replaced = matcher.replaceAll("0");

        System.out.println(replaced);


    }
}
