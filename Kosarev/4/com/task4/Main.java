package com.task4;

import com.task4.core.Char.Builders.MageBuilder;
import com.task4.core.Char.Builders.MonsterBuilder;
import com.task4.core.Char.Mage;
import com.task4.core.Char.Monster;
import com.task4.core.Scene;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scene foo = new Scene();
        Monster urukHai = new MonsterBuilder()
                .setScene(foo)
                .setScenePos(foo.nextFreePos())
                .setName("Uruk-Hai")
                .createMonster();
        Monster sauron = new MonsterBuilder()
                .setScene(foo)
                .setScenePos(foo.nextFreePos())
                .setName("Sauron")
                .createMonster();
        Mage gandalf = new MageBuilder()
                .setScene(foo)
                .setScenePos(foo.nextFreePos())
                .setName("Gandalf")
                .setSpellbook(List.of("Исцеление", "Цепная молния", "Молния"))
                .createMage();
        System.out.println(foo.sceneView());
        gandalf.prepareSpell("Исцеление", gandalf).cast();
        gandalf.prepareSpell("Исцеление", gandalf).cast();
        sauron.attack(urukHai);
        sauron.attack(urukHai);
        sauron.attack(urukHai);
        gandalf.prepareSpell("Исцеление", urukHai).cast();
        sauron.attack(urukHai);
        sauron.attack(urukHai);
        sauron.attack(urukHai);
        foo.process();

        System.out.println(foo.sceneView());
    }
}
