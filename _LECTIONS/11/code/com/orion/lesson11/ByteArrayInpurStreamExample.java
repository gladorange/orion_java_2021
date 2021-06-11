package com.orion.lesson11;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInpurStreamExample {


    public static void main(String[] args) throws IOException {
        byte[] bytes = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        printStream(bis);

    }

    private static void printStream(InputStream bis) throws IOException {
        int read = 0;
        while ((read = bis.read()) != -1) {
            System.out.print((char) read);
            System.out.print(' ');
        }
    }
}
