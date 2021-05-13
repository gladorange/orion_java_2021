package com.task4.core.Char;

import com.task4.core.Scene;


abstract public class Char {
    private int hp;
    private String name;
    private Scene scene;
    private int scenePos;

    abstract public int getMaxHp();
    abstract public String toSceneView();

    public boolean checkCanInteractWith(Char target) {
        return scene == target.scene;
    }

    public boolean checkIfDead() {
        if (hp > 0)
            return false;
        System.out.printf("%s убит!\n", name);
        scene.del(this);
        return true;
    }

    public Char(int hp, String name, Scene scene, int scenePos) {
        this.hp = hp;
        this.name = name;
        this.scene = scene;
        this.scenePos = scenePos;
        scene.set(this, scenePos);
        System.out.printf("%s вошел на сцену\n", name);
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp, getMaxHp());
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public int getScenePos() {
        return scenePos;
    }
}
