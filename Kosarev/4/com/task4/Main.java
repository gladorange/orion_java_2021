package com.task4;

import com.task4.core.Chars.Builders.MonsterBuilder;
import com.task4.core.Chars.Monster;
import com.task4.core.Scene.Scene;


public class Main {
    public static void main(String[] args) {
        Scene testScene = new Scene(10);
        Monster foo1 = new MonsterBuilder()
                .setScene(testScene)
                .setPos(0)
                .setName("Uruk-Hai")
                .setHp(100)
                .setMaxhp(100)
                .setDmg(20)
                .createMonster();
        Monster foo2 = new MonsterBuilder()
                .setScene(testScene)
                .setPos(1)
                .setName("Boromir")
                .setHp(40)
                .setMaxhp(100)
                .setDmg(20)
                .createMonster();
        System.out.println(testScene.toString());
        foo1.attack(foo2.getPos());
        foo1.attack(foo2.getPos());
        foo1.attack(foo2.getPos());
        testScene.processChars();
        System.out.println(testScene.toString());
    }
}
