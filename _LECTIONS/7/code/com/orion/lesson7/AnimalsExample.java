package com.orion.lesson7;

import java.util.List;

public class AnimalsExample {


    static abstract class Animal {
        abstract void makeNoise();
    }


    static class Dog extends Animal {

        @Override
        void makeNoise() {
            System.out.println("гав");
        }
    }


    static class Cat extends Animal {

        @Override
        void makeNoise() {
            System.out.println("Мяу");
        }
    }


    public static void main(String[] args) {
       /* Animal[] animals = {new Cat(), new Dog()};
        doALotOfNoise(animals);

        Dog[] dogsArray = { new Dog(), new Dog()};
        doALotOfNoise(dogsArray);
*/
        List<Animal> animalsList = List.of(new Cat(), new Dog());
        doALotOfNoiseCollection(animalsList);

        /*List<Dog> dogs = List.of(new Dog(), new Dog());
        doALotOfNoiseCollection(dogs);*/
    }


    public static void doALotOfNoise(Animal[] animals) {
        for (Animal animal : animals) {
            animal.makeNoise();
        }
        //animals[0] = new Cat();
    }


    public static void doALotOfNoiseCollection(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.makeNoise();
        }
        animals.add(new Dog());
    }






}
