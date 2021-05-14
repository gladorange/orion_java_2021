package com.task4.core.Char.Builders;

import com.task4.core.Char.Mage;
import com.task4.core.Scene;
import com.task4.core.Spell.Spellconsts;

import java.util.List;

public class MageBuilder {
    private int hp = Mage.MAX_HP;
    private String name;
    private Scene scene;
    private int scenePos;
    private List<Spellconsts> spellbook;

    public MageBuilder setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public MageBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MageBuilder setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public MageBuilder setScenePos(int scenePos) {
        this.scenePos = scenePos;
        return this;
    }

    public MageBuilder setSpellbook(List<Spellconsts> spellbook) {
        this.spellbook = spellbook;
        return this;
    }

    public Mage createMage() {
        return new Mage(hp, name, scene, scenePos, spellbook);
    }
}