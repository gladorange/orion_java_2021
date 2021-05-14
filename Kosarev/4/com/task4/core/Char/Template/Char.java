package com.task4.core.Char.Template;

import com.task4.core.Scene;


abstract public class Char {
    private int hp;
    private static String charClass;
    private String name;
    private Scene scene;
    private int scenePos;

    protected Char() {
    }

    abstract public int getMaxHp();

    public String toSceneView() {
        return getName();
    }

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

    public Char(int hp, String name, Scene scene, int scenePos, String charClass) {
        this.hp = hp;
        this.name = name;
        this.scene = scene;
        this.scenePos = scenePos;
        Char.charClass = charClass;
        scene.set(this, scenePos);
        System.out.printf("%s %s вошел на сцену на %d слот\n", charClass, name, scenePos);
    }

    public void sufferDmg(int dmg) {
        setHp(hp - dmg);
        System.out.printf("Здоровье %s: %d\n", name, hp);
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

    public Scene getScene() {
        return scene;
    }

    public String getCharClass() {
        return charClass;
    }
}
