package com.task4;

import com.task4.core.Chars.Builders.MonsterBuilder;
import com.task4.core.Scene.Scene;
import com.task4.core.SceneViewable;


public class Main {
    public static void main(String[] args) {
        Scene testScene = new Scene(10);
        SceneViewable monster = new MonsterBuilder()
                .setScene(testScene)
                .setPos(1)
                .setName("Uruk-Hai")
                .setHp(100)
                .setMaxhp(100)
                .setDmg(20)
                .createMonster();
        System.out.println(testScene.toString());
    }
}
