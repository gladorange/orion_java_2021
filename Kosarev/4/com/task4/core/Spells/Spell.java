package com.task4.core.Spells;


public abstract class Spell {
    private final String name;

    abstract public void cast();

    public Spell(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Заклинание \"" + name + "\"";
    }
}
