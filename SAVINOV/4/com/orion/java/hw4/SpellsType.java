package com.orion.java.hw4;

public enum SpellsType {
    HEALING("Исцеление", 5, 20),
    LIGHTNING("Молния", 10, 15),
    CHAIN_LIGHTNING("Цепная молния", 5, 8),
    WALL_OF_FIRE("Стена огня", 10, 10),
    FIERY_TOUCH("Огненное касание", 22, 30),
    EXPELLING_MONSTERS("Изгнание монстров", 10, 10),
    MIGRAINE("Мигрень", 10, 10);

    private String spellName;
    private int power;

    SpellsType(String spellName, int minPower, int maxPower) {
        this.spellName = spellName;
        this.power = getRandomPower(minPower, maxPower);
    }

    public String getSpellName() {
        return spellName;
    }

    public int getPower() {
        return power;
    }

    private int getRandomPower(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}