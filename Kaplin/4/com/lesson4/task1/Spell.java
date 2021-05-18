package com.lesson4.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Spell {
    private final String name;
    private final AttackEffect attackEffect;


    public Spell(String name, AttackTargetType attackTargetType, int healthModifier) {
        this.name = name;
        this.attackEffect = new AttackEffect(attackTargetType, AttackType.SPELL, healthModifier);
    }

    public Spell(String name, AttackTargetType attackTargetType, int healthModifier, Set<Class> classesResist) {
        this.name = name;
        this.attackEffect = new AttackEffect(attackTargetType, AttackType.SPELL, healthModifier, classesResist);
    }

    public AttackEvent cast(List<Person> scene, Person attacker,  ArrayList<Integer> liveIndexes) {
        return attackEffect.attack( scene, attacker, liveIndexes, name);
    }
}
