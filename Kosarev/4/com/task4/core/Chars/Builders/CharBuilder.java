package com.task4.core.Chars.Builders;

import com.task4.core.Chars.Char;
import com.task4.core.Scene.Scene;

public class CharBuilder {
    private Scene scene;
    private int pos;
    private String name;
    private int hp;
    private int maxhp;

    public CharBuilder setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public CharBuilder setPos(int pos) {
        this.pos = pos;
        return this;
    }

    public CharBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CharBuilder setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public CharBuilder setMaxhp(int maxhp) {
        this.maxhp = maxhp;
        return this;
    }

    public Char createChar() {
        return new Char(scene, pos, name, hp, maxhp);
    }
}