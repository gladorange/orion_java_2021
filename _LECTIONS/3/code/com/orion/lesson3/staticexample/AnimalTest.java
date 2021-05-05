package com.orion.lesson3.staticexample;

import com.orion.lesson3.staticexample.Animal.AnimalBuilder;

public class AnimalTest {




    public static void main(String[] args) {

        System.out.println("Start");
        System.out.println(Animal.DEFAULT_NAME);
        System.out.println("Before object creation");
        final Animal sharik = new AnimalBuilder().setName("Sharik").createAnimal();
        System.out.println(sharik.name);


        System.out.println(Animal.getAnimalCount());
    }
}
