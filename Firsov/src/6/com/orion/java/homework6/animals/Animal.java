package com.orion.java.homework6.animals;

import com.orion.java.homework6.elementtypes.Pair;

import java.util.List;
import java.util.Random;

public class Animal {

    private String name;
    private String type;

    public Animal(String name, String type ) {
        this.name = name;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public static void feedAnimals( List<Pair<Animal,String>> pairList ){
        int randomNumber = new Random().nextInt( pairList.size() );
        Pair<Animal,String> happyAnimal = pairList.get(randomNumber);
        for( Pair<Animal, String > pair : pairList ){
            System.out.printf( "Животное %s с радостью съедает %s \n", pair.getFirst().name, pair.getSecond());
        }
        System.out.printf( "Счастливое животное %s получает двойную порцию %s \n", happyAnimal.getFirst().name,
                happyAnimal.getSecond() );
    }
}
