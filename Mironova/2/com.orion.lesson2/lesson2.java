package com.orion.java.lesson2;

public class lesson2 {

    public static void main(String[] args){

        System.out.println("\n");

        MagicNumberTask MagicNumber = new MagicNumberTask("MagicNumber", 100);
        System.out.println("Starting the " + MagicNumber.getName());
        MagicNumber.generateWorkspace(-100, 100);
        MagicNumber.getResult();

        System.out.println("\n");

        OppositeSignsTask OppositeSign = new OppositeSignsTask("Opposite sign", 10);
        System.out.println("Starting the " + OppositeSign.getName());
        OppositeSign.generateWorkspace();
        OppositeSign.showWorkspace();
        OppositeSign.getResult();
    }

}

