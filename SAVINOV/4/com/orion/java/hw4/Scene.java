package com.orion.java.hw4;

import java.util.*;

public class Scene {
    private int countCells;

    public Scene(int countCells) {
        this.countCells = countCells;
    }

    public List<Character> createScene() {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < countCells; i++) {
            characterList.add(getCharacter(i));
        }
        return characterList;
    }

    private Character getCharacter(int i) {
        int randomNumber = new Random().nextInt(2);
        switch (randomNumber) {
            case 0: {
                Monster monster = new Monster("Монстр_" + i, 100);
                monster.setPosition(i);
                return monster;
            }
            case 1: {
                Mag mag = new Mag("Маг_" + i, 100, 3);
                mag.setPosition(i);
                return mag;
            }
            default: {
                return null;
            }
        }
    }

    public int countOfAliveCharacters(List<Character> characterList) {
        return (int) characterList.stream()
                .filter(Character::isAlive)
                .count();
    }

    public void printCharacters(List<Character> characterList) {
        for (int i = 0; i < characterList.size(); i++) {
            System.out.println(characterList.get(i).getNameCharacter());
        }
    }

    public void printWinnerCharacter(List<Character> characterList) {
        for (Character character : characterList) {
            if(character.isAlive()){
                System.out.println(character.getNameCharacter() + " победил");
            }
        }
    }
}