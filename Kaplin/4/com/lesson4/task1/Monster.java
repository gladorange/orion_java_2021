package com.lesson4.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Person {
    private final AttackEffect attackEffect;
    public Monster(String name, int health, int healthModifier) {
        super(name, health);
        this.attackEffect = new AttackEffect( AttackTargetType.ONE, AttackType.MELEE, healthModifier);
    }

    @Override
    public AttackEvent attack(List<Person> scene, ArrayList<Integer> liveIndexes) {
        return attackEffect.attack(scene, this, liveIndexes, "Когтями");

    }

    @Override
    public String toString() {
        return "Монстр " + super.getName();
    }
}
