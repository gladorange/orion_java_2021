package com.task4.core.Char.Builders;

import com.task4.core.Char.Paladin;
import com.task4.core.Scene;

public class PaladinBuilder {
    private int hp = Paladin.MAX_HP;
    private String name;
    private Scene scene;
    private int scenePos;

    public PaladinBuilder setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public PaladinBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PaladinBuilder setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public PaladinBuilder setScenePos(int scenePos) {
        this.scenePos = scenePos;
        return this;
    }

    public Paladin createPaladin() {
        return new Paladin(hp, name, scene, scenePos);
    }
}