package com.task4.core.Char.Builders;

import com.task4.core.Char.Monster;
import com.task4.core.Scene;

public class MonsterBuilder {
    private int hp = Monster.MAX_HP;
    private String name;
    private Scene scene;
    private int scenePos;

    public MonsterBuilder setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public MonsterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MonsterBuilder setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public MonsterBuilder setScenePos(int scenePos) {
        this.scenePos = scenePos;
        return this;
    }

    public Monster createMonster() {
        return new Monster(hp, name, scene, scenePos);
    }
}