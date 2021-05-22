package com.lesson4.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mage extends Person {
    private final SpellBook spellBook;
    public Mage(String name, Integer health, SpellBook spellBook) {
        super(name, health);
        this.spellBook = spellBook;
    }

    @Override
    public AttackEvent attack(List<Person> scene,  ArrayList<Integer> liveIndexes) {
        int randomSpell = new Random().nextInt(spellBook.getSpells().size());
        Spell spell = spellBook.getSpells().get(randomSpell);
        return spell.cast(scene, this,  liveIndexes);

    }

    @Override
    public String toString() {
        return "Маг " + super.getName();
    }
}
