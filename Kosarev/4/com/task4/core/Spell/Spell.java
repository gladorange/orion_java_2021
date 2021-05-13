package com.task4.core.Spell;

import com.task4.core.Char.Char;
import com.task4.core.Char.Spellcasting;

public class Spell {
    private String name;
    private Spellcasting caster;
    private Char target;

    public void cast() {
        System.out.printf("%s читает заклинание \"%s\"\n", ((Char)caster).getName(), name);
    }

    public Spell(String name, Spellcasting caster, Char target) {
        this.name = name;
        this.caster = caster;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public Spellcasting getCaster() {
        return caster;
    }

    public Char getTarget() {
        return target;
    }

    public void setTarget(Char target) {
        this.target = target;
    }
}
