package com.orion.lesson11;

import java.nio.file.Files;
import java.nio.file.Path;

public class Nio2 {


    public static void main(String[] args) {


        final Path lection5 = Path.of("C:\\programming\\students\\orion_java_2021\\_LECTIONS\\5");
        System.out.println("Parent:" + lection5.getParent());
        System.out.println("Resolve:" +lection5.resolve("code42"));


        System.out.println(Files.exists(lection5.getParent()));
        System.out.println(Files.exists(lection5.resolve("code42")));


    }

}
