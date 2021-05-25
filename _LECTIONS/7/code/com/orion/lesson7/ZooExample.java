package com.orion.lesson7;

import java.util.ArrayList;
import java.util.List;

import com.orion.lesson7.AnimalsExample.Animal;
import com.orion.lesson7.AnimalsExample.Cat;
import com.orion.lesson7.AnimalsExample.Dog;

public class ZooExample {


    public static void main(String[] args) {


        List<Animal> zoo = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();

        addDogToZoo(zoo);
        addDogToZoo(dogs);

      //  addDogToZoo(cats);

        List<? super Dog> animals = new ArrayList<Animal>();

    }

    public static void addDogToZoo(List<? super Dog> animals) {
        animals.add(new Dog());

        for (Object animal : animals) {

        }


    }


}
