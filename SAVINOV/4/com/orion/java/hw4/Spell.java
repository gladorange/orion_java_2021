package com.orion.java.hw4;

public class Spell {
    private SpellsType typeSpell;

    public Spell(SpellsType typeSpell) {
        this.typeSpell = typeSpell;
    }

    public void cast(Character character) {
        System.out.println(character.getNameCharacter() + " произнес заклинание: " + typeSpell.getSpellName());
    }

    public SpellsType getTypeSpell() {
        return typeSpell;
    }
}