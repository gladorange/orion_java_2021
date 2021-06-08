package com.orion.lesson11;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BufferedOutputStreamsExample {


    public static void main(String[] args) throws Exception {

        OutputStream fos = new BufferedOutputStream(new FileOutputStream("some-text"));
        fos.write(50);
        fos.flush();

    }
}
