package com.orion.lesson11;

import java.io.File;
import java.io.IOException;

public class FileExample {


    public static void main(String[] args) throws IOException {


        final File file = new File("new-file.txt");
        file.createNewFile();

        if (file.exists()) {
            System.out.println("File FOUND");
        } else {
            System.out.println("NOT FOUND");
        }



        final File dir = new File("new-dir");
        dir.mkdir();

        for (String s : dir.list()) {
            System.out.println(s);
        }


        if (file.isDirectory()) {
            for (String s : file.list()) {
                System.out.println(s);
            }
        }
    }
}
