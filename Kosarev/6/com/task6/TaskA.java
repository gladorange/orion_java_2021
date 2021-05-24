package com.task6;

import com.task6.Tuples.Pair;

import java.util.List;
import java.util.Random;

public class TaskA {

    private static class Animal {
        private String name;
        private String type;

        public Animal(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        enum AnimalType {
            DOG("Пес"),
            CAT("Кот"),
            HEDGEHOG("Еж"),
            CHICKEN("Курица"),
            GIRAFFE("Жираф");

            private String type;

            AnimalType(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }
        }
    }

    private static void feedAnimals(List<Pair<Animal, String>> animalFoodPairs) {
        Animal luckyAnimal = animalFoodPairs.get(new Random().nextInt(animalFoodPairs.size())).getFirst();
        animalFoodPairs.forEach(afPair -> {
            if (afPair.getFirst() == luckyAnimal)
                System.out.printf("Счастливый %s %s получает двойную порцию %s!%n",
                        afPair.getFirst().getType(),
                        afPair.getFirst().getName(),
                        afPair.getSecond());
            System.out.printf("%s %s с радостью съедает %s%n",
                    afPair.getFirst().getType(),
                    afPair.getFirst().getName(),
                    afPair.getSecond());
        });
    }

    public static void run() {
        System.out.println("Задание А. Работа с парами:\n");
        List<Pair<Animal, String>> animalsFoodMap = List.of(
                new Pair<>(new Animal("Шарик", Animal.AnimalType.DOG.getType()), "Мясо"),
                new Pair<>(new Animal("Мурзик", Animal.AnimalType.CAT.getType()), "Рыба"),
                new Pair<>(new Animal("Соник", Animal.AnimalType.HEDGEHOG.getType()), "Молоко"),
                new Pair<>(new Animal("Чико", Animal.AnimalType.CHICKEN.getType()), "Зерно"),
                new Pair<>(new Animal("Мелман", Animal.AnimalType.GIRAFFE.getType()), "Листья")
        );
        feedAnimals(animalsFoodMap);
        System.out.println("--------------------------------------------------------------");
    }

}
