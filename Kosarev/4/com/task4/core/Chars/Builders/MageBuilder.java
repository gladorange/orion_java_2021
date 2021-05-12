package com.task4.core.Chars.Builders;

import com.task4.core.Chars.Mage;
import com.task4.core.Scene.Scene;
import com.task4.core.Spells.Spell;

public class MageBuilder {
    private Scene scene;
    private int pos;
    private String name;
    private int hp;
    private int maxhp;
    private Spell[] spellbook;

    public MageBuilder setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public MageBuilder setPos(int pos) {
        this.pos = pos;
        return this;
    }

    public MageBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MageBuilder setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public MageBuilder setMaxhp(int maxhp) {
        this.maxhp = maxhp;
        return this;
    }

    public MageBuilder setSpellbook(Spell[] spellbook) {
        this.spellbook = spellbook;
        return this;
    }

    public Mage createMage() {
        return new Mage(scene, pos, name, hp, maxhp, spellbook);
    }
}