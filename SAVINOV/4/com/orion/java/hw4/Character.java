package com.orion.java.hw4;

import java.util.*;

public abstract class Character {
    private int healthPoint;
    private String nameCharacter;
    private int position;
    private boolean isAlive = true;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public Character(String nameCharacter, int healthPoint) {
        this.nameCharacter = nameCharacter;
        this.healthPoint = healthPoint;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public abstract void move(List<Character> characterList);

    public boolean checkAlive() {
        if (this.getHealthPoint() <= 0)
            this.setAlive(false);
        return this.isAlive();
    }
}