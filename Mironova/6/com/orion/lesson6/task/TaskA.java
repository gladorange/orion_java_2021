package com.orion.lesson6.task;

import com.orion.lesson6.task.taskA.Animal;
import com.orion.lesson6.tuple.Pair;
import java.util.List;
import java.util.Random;

public class TaskA implements Task {

    public List<Pair<Animal, String>> dataList;

    @Override
    public void initData() {
        this.dataList = List.of(
                new Pair<Animal, String>(new Animal(Animal.AnimalType.DOG.getName(), "Шарик"), "мясо"),
                new Pair<Animal, String>(new Animal(Animal.AnimalType.DOG.getName(), "Бобик"), "кости"),
                new Pair<Animal, String>(new Animal(Animal.AnimalType.HORSE.getName(), "Булат"), "морковь"),
                new Pair<Animal, String>(new Animal(Animal.AnimalType.RABBIT.getName(), "Королик"), "морковь"));
    }

    @Override
    public void printData() {
        dataList.forEach(e -> System.out.println(String.format("%s %s любит %s", e.getFirst().getType(), e.getFirst().getName(), e.getSecond())));
    }

    @Override
    public void actionTask(){
        feedAnimals();
    }

    private void feedAnimals() {

        int rand = new Random().nextInt(this.dataList.size());

        for (int i = 0; i < this.dataList.size(); i++) {
            System.out.println(String.format("Животное %s с радостью съедает %s", this.dataList.get(i).getFirst().getType(), this.dataList.get(i).getSecond()));
            if (i == rand) {
                System.out.println(String.format("Счастиливое животное %s получает двойную порцию %s", this.dataList.get(i).getFirst().getType(), this.dataList.get(i).getSecond()));
            }
        }

    }
}
