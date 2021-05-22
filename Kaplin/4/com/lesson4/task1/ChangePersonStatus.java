package com.lesson4.task1;

public class ChangePersonStatus {
    private String name;
    private int healthModifier;
    private int resultHealth;
    private boolean isDead;

    public ChangePersonStatus(String name, int healthModifier, int resultHealth, boolean isDead) {
        this.name = name;
        this.healthModifier = healthModifier;
        this.resultHealth = resultHealth;
        this.isDead = isDead;
    }

    public String getName() {
        return name;
    }

    public int getHealthModifier() {
        return healthModifier;
    }

    public int getResultHealth() {
        return resultHealth;
    }

    public boolean isDead() {
        return isDead;
    }
}
