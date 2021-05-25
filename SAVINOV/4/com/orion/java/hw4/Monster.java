package com.orion.java.hw4;

import java.util.*;

public class Monster extends Character{
    private int power;

    public Monster(String nameCharacter, int healthPoint) {
        super(nameCharacter, healthPoint);
        this.power = getRandomPower(7, 25);
    }

    @Override
    public void move(List<Character> characterList) {
        int randomPosition;
        Character character;
        do {
            randomPosition = new Random().nextInt(characterList.size());
            character = characterList.get(randomPosition);
        } while (this.getPosition() == randomPosition || !character.isAlive());

        if (character != null) {
            int wasHP = character.getHealthPoint();
            int becameHP = wasHP - power;
            character.setHealthPoint(becameHP);
            if (character.checkAlive()) {
                System.out.printf("%s атакует %s на %d единиц урона. %s HP: %d, %s HP: %d\n", this.getNameCharacter(), character.getNameCharacter(), power,
                        this.getNameCharacter(), this.getHealthPoint(), character.getNameCharacter(), character.getHealthPoint());
            } else {
                System.out.printf("%s атакует %s на %d единиц урона и убивает его\n", this.getNameCharacter(), character.getNameCharacter(), power);
            }
        } else {
            System.out.printf("%s промахнулся\n", this.getNameCharacter());
        }
    }

    private int getRandomPower(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}