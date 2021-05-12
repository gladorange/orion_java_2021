package com.task4.core.Chars;

import com.task4.core.Scene.Scene;
import com.task4.core.SceneViewable;


public class Char implements SceneViewable {
    private int hp;
    private int maxhp;
    private String name;
    private Scene scene;
    private int pos;

    public Char(Scene scene, int pos, String name, int hp, int maxhp) {
        this.hp = hp;
        this.maxhp = maxhp;
        this.name = name;
        this.scene = scene;
        this.pos = pos;
        scene.add(this, pos);
    }

    @Override
    public String toSceneView() {
        return "Char";
    }
}
