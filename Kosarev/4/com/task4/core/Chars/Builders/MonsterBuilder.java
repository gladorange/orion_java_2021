package com.task4.core.Chars.Builders;

import com.task4.core.Chars.Monster;
import com.task4.core.Scene.Scene;

public class MonsterBuilder {
    private Scene scene;
    private int pos;
    private String name;
    private int hp;
    private int maxhp;
    private int dmg;

    public MonsterBuilder setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public MonsterBuilder setPos(int pos) {
        this.pos = pos;
        return this;
    }

    public MonsterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MonsterBuilder setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public MonsterBuilder setMaxhp(int maxhp) {
        this.maxhp = maxhp;
        return this;
    }

    public MonsterBuilder setDmg(int dmg) {
        this.dmg = dmg;
        return this;
    }

    public Monster createMonster() {
        return new Monster(scene, pos, name, hp, maxhp, dmg);
    }
}