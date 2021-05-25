package com.lesson6.task1;

import com.lesson6.utils.Pair;

import java.util.List;
import java.util.Random;

public class Animal {
    final private String name;
    final private AnimalsTypes type;


    public Animal(String name, AnimalsTypes type) {
        this.name = name;
        this.type = type;
    }

    public static void feedAnimals(List<Pair<Animal, Food>> pairAnimalList) {
        int luckyIndex = new Random().nextInt(pairAnimalList.size());
        for(int i = 0; i < pairAnimalList.size(); i++){
            boolean isLucky = i == luckyIndex;
            feedOneAnimal(isLucky, pairAnimalList.get(i));
        }
    }
    private static void feedOneAnimal(boolean isLucky, Pair<Animal, Food> pair) {
        String animalString;
        String foodString;
        if(isLucky) {
            animalString = "Счастливое животное";
            foodString = "двойную порцию";
        } else {
            animalString = "Животное";
            foodString = "обычную порцию";
        }
        System.out.printf("%s %s %s съедает %s %s%n", animalString, pair.getFirst().getType().toString(),
                pair.getFirst().getName(), foodString, pair.getSecond().toString());
    }

    public String getName() {
        return name;
    }

    public AnimalsTypes getType() {
        return type;
    }
}
