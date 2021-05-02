package com.orion.lesson2;

public class ObjectVsPrimitive {


    public static void main(String[] args) {
        boolean bValue = true;

        int ivalue = 1;
        long lValue = 42L;
        float fValue = 0.2f;
        double dValue = 25.d;

        short sValue = 2;

        byte byteValue = 127;
        char cvalue = 'A';

        printInt(ivalue);

    }

    static void printInt(Integer objectReference) {
        System.out.println(objectReference);
    }

}
