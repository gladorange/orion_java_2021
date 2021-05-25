package com.orion.lesson8;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class MethodReference {






    static abstract class Animal {
        String name;

        abstract void saySomething();
    }


    static class Dog extends Animal {

        public Dog(String name) {
            this.name = name;
        }

        @Override
        void saySomething() {
            System.out.println("Гав");
        }
    }

    static class Cat extends Animal {

        //        Animal createAnimal(String name);
        public Cat(String name) {
            this.name = name;
        }

        @Override
        void saySomething() {
            System.out.println("Мяу");
        }
    }


    public static void main(String[] args) {
       /* Supplier<? extends Animal> catSupplier  =() -> new Cat("Кошка");
        Supplier<? extends Animal> dogSupplier  =() -> new Dog("Собака");



        final Animal animal = catSupplier.get();
        System.out.println(animal.name);
        animal.saySomething();



        for (int i = 0; i < 10; i++) {
            if (new Random().nextBoolean()) {
                animals.add(catSupplier.get());
            } else {
                animals.add(dogSupplier.get());
            }
        }


        for (Animal animal : animals) {
            animal.saySomething();
        }
        */

        List<String> names = List.of("Машка", "Барбос");
        AnimalSupplier catSupplier = Cat::new;
        AnimalSupplier dogSupplier = name -> new Dog(name);

        List<Animal> animals = new ArrayList<>();

        for (String name : names) {
            if (new Random().nextBoolean()) {
                animals.add(catSupplier.createAnimal(name));
            } else {
                animals.add(dogSupplier.createAnimal(name));
            }
        }


        for (Animal animal : animals) {

            System.out.println(animal.name);
            animal.saySomething();
        }


    }


    interface AnimalSupplier {
        Animal createAnimal(String name);
    }









}
