package com.orion.java.hw6.taskA;

import com.orion.java.hw6.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        feedAnimals(initListWithAnimals());
    }

    static List<Pair<Animal, String>> initListWithAnimals() {
        List<Pair<Animal, String>> listAnimal = new ArrayList<>();
        listAnimal.add(new Pair<>(new Animal("Носорог", "Парнокопытные"), "Трава"));
        listAnimal.add(new Pair<>(new Animal("Лев", "Хищные"), "Зебра"));
        listAnimal.add(new Pair<>(new Animal("Ежик", "Насекомоядные"), "Жук"));
        listAnimal.add(new Pair<>(new Animal("Слон", "Хоботные"), "Фрукты"));
        return listAnimal;
    }

    static void feedAnimals(List<Pair<Animal, String>> listWithAnimals) {
        int luckyAnimalNumber = new Random().nextInt(listWithAnimals.size());
        for (int i = 0; i < listWithAnimals.size(); i++) {
            if (i == luckyAnimalNumber) {
                System.out.printf("Счастливое животное '%s' получает двойную двойную порцию '%s'\n", listWithAnimals.get(i).getFirst().getName(), listWithAnimals.get(i).getSecond());
            } else {
                System.out.printf("Животное '%s' с радостью съедает блюдо '%s'\n", listWithAnimals.get(i).getFirst().getName(), listWithAnimals.get(i).getSecond());
            }
        }
    }
}
