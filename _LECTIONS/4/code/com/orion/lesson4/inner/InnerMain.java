package com.orion.lesson4.inner;

import com.orion.lesson4.TopPublic;

public class InnerMain {

    public static void main(String[] args) {
        String person = "PERSON";
        final String per = person.replace("PER", "");
        System.out.println(per);
    }
}
