package home.work6.task.a;

import home.work6.task.pairs.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalApp {

    public void doTask(){

        List<Pair<Animal,String>> list = new ArrayList<>();
        list.add(new Pair<>(new Animal("Tiger", "Predator"), "Meat"));
        list.add(new Pair<>(new Animal("Lion", "Predator"), "Meat"));
        list.add(new Pair<>(new Animal("Mouse", "Rodent"), "Groats"));
        list.add(new Pair<>(new Animal("Cat", "Pet"), "Wiskas"));
        list.add(new Pair<>(new Animal("Dog", "Pet"), "DryFood"));
        feedAnimals(list);
    }

    private void feedAnimals(List<Pair<Animal,String>> list){
        int luckyNumber = new Random().nextInt(list.size());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            if (i==luckyNumber){
                sb.append("Счастливое животное ").append(list.get(i).geFirst().getName())
                        .append(" получает двойную порцию ").append(list.get(i).getSecond()).append(".\n");
            }else{
                sb.append("Животное ").append(list.get(i).geFirst().getName()).append(" с радостью съедает ")
                        .append(list.get(i).getSecond()).append(".\n");
            }
        }
        System.out.println(sb.toString());
    }
}
