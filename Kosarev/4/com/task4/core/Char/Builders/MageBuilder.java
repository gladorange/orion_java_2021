package com.task4.core.Char.Builders;

import com.task4.core.Char.Mage;
import com.task4.core.Scene;

import java.util.List;

public class MageBuilder {
    private int hp = Mage.MAX_HP;
    private String name;
    private Scene scene;
    private int scenePos;
    private List<String> spellbook;

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

    public MageBuilder setSpellbook(List<String> spellbook) {
        this.spellbook = spellbook;
        return this;
    }

    public Mage createMage() {
        return new Mage(hp, name, scene, scenePos, spellbook);
    }
}