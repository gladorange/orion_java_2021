package com.orion.lesson3.staticexample;

import java.util.Random;

public class Animal {

    public static class AnimalBuilder {
        private String name;

        public AnimalBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Animal createAnimal() {
            return new Animal(name);
        }
    }

    final static String DEFAULT_NAME = "Barsik";
    final static Animal someAnimal;

    static {
        if (new Random().nextBoolean()) {
            someAnimal = new AnimalBuilder().setName("Barsik").createAnimal();
        } else {
            someAnimal = new AnimalBuilder().setName("Murka").createAnimal();
        }
    }


    public static int animalCount = 0;


    String name;
    {
        System.out.println(" Hello from init block!");
    }
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
