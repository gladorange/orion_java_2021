package com.lesson6.task1;

import com.lesson6.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal("Муська", AnimalsTypes.CAT);
        Animal dog = new Animal("Джим", AnimalsTypes.DOG);
        Animal mouse = new Animal("Норушка", AnimalsTypes.MOUSE);
        Animal bear = new Animal("Косолапый", AnimalsTypes.BEAR);

        List<Pair<Animal,Food >> pairAnimalList = new ArrayList<>( Arrays.asList(
                new Pair<>(cat, Food.MILK),
                new Pair<>(dog, Food.MEAT),
                new Pair<>(mouse, Food.CHEES),
                new Pair<>(bear, Food.HONEY)
        ));

        Animal.feedAnimals(pairAnimalList);

    }
}
