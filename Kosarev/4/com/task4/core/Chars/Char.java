package com.task4.core.Chars;

import com.task4.core.Scene.Scene;
import com.task4.core.SceneViewable;


public class Char implements SceneViewable {
    protected int hp;
    protected int maxhp;
    protected String name;
    protected Scene scene;
    private int pos;

    public Char(Scene scene, int pos, String name, int hp, int maxhp) {
        this.hp = hp;
        this.maxhp = maxhp;
        this.name = name;
        this.scene = scene;
        this.pos = pos;
        scene.add(this, pos);
    }

    public boolean checkIfDead() {
        if (hp <= 0) {
            scene.del(pos);
            System.out.printf("%s убит\n", name);
            return true;
        }
        return false;
    }

    public int getPos() {
        return pos;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > maxhp)
            hp = maxhp;
        this.hp = hp;
    }

    @Override
    public String toSceneView() {
        return "Char";
    }
}
