package com.task4.core.Chars;

import com.task4.core.Scene.Scene;
import com.task4.core.SceneViewable;


public class Monster extends Char implements SceneViewable {
    private int dmg;

    public Monster(Scene scene, int pos, String name, int hp, int maxhp, int dmg) {
        super(scene, pos, name, hp, maxhp);
        this.dmg = dmg;
    }

    public void attack(int fieldId) {

    }

    @Override
    public String toSceneView() {
        return "Mnst";
    }
}
