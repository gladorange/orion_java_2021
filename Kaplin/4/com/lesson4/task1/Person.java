package com.lesson4.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * base class for all persons on scene
 */
public abstract class Person {

    private String name;
    private int health;
    private int maxHealth;

    public Person(String name, int health) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
    }

    /** This method must be override in every person class
     * @param scene scene of  game
     * @param liveIndexes indexes with live persons on scene
     * @return event of this step from AttackEffect
     */
    public AttackEvent attack(List<Person> scene, ArrayList<Integer> liveIndexes) {
        return null;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    /**
     * @param healthModifier modifier of person health
     * @return ChangePersonStatus - this is part of attack event, contains statuses of person after attack
     */
    public ChangePersonStatus beingAttacked(int healthModifier) {
        int resultHealth = Math.max(health + healthModifier, 0);
        health = Math.min(resultHealth, maxHealth);
        return new ChangePersonStatus(name, healthModifier, health, health == 0);
    }

}
