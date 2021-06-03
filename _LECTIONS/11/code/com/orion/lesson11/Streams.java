package com.orion.lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Streams {


    public static void main(String[] args) throws IOException {

        //InputStream is = new FileInputStream("text");

        /*

        int value = 0;
        while ( (value = is.read() ) != -1) {
            System.out.print(value);
        }
*/

        try (FileReader is = new FileReader("text")) {
            char[] value = new char[200];
            final int read = is.read(value);
            System.out.println(new String(value, 0, read));
        }





    }


}
