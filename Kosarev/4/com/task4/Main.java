package com.task4;

import com.task4.core.Chars.Builders.MageBuilder;
import com.task4.core.Chars.Builders.MonsterBuilder;
import com.task4.core.Chars.Mage;
import com.task4.core.Chars.Monster;
import com.task4.core.Scene.Scene;


public class Main {
    public static void main(String[] args) {
        Scene testScene = new Scene(10);
        Monster urukHai = new MonsterBuilder()
                .setScene(testScene)
                .setPos(0)
                .setName("Uruk-Hai")
                .setHp(100)
                .setMaxhp(100)
                .setDmg(20)
                .createMonster();
        Monster boromir = new MonsterBuilder()
                .setScene(testScene)
                .setPos(1)
                .setName("Boromir")
                .setHp(40)
                .setMaxhp(100)
                .setDmg(20)
                .createMonster();
        Mage saruman = new MageBuilder()
                .setScene(testScene)
                .setPos(2)
                .setName("Saruman")
                .setHp(40)
                .setMaxhp(40)
                .createMage();
        System.out.println(testScene.toString());
        urukHai.attack(boromir.getPos());
        urukHai.attack(boromir.getPos());
        urukHai.attack(boromir.getPos());
        testScene.processChars();
        System.out.println(testScene.toString());
    }
}
