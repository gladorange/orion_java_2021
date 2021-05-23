package com.orion.java.hw4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println(SpellsType.spellsTypeList.get(new Random().nextInt(SpellsType.spellsTypeList.size())));
        Scene scene = new Scene(10);
        List<Character> characterList = scene.createScene();
        scene.printCharacters(characterList);

        while (scene.countOfAliveCharacters(characterList) > 1) {
            for (Character character : characterList) {
                if (Objects.nonNull(character) && character.isAlive()) {
                    character.move(characterList);
                }
            }
        }
        scene.printWinnerCharacter(characterList);
    }
}