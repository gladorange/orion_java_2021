package com.task4.core;

import com.task4.core.Char.Builders.MageBuilder;
import com.task4.core.Char.Builders.MonsterBuilder;
import com.task4.core.Char.Builders.PaladinBuilder;
import com.task4.core.Char.Mage;
import com.task4.core.Char.Monster;
import com.task4.core.Char.Paladin;
import com.task4.core.Char.Template.Attacking;
import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Template.Spellcasting;
import com.task4.core.Spell.Spellconsts;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Game {
    private Scene scene;  // ?: стоит ли сделать scene final (может ли во время идущей игры выйти новый Char)?
    private int turn = 0;

    private Scanner scanner = new Scanner(System.in);
    
    private void claimAction(Char acting, Char target, String actionStr) {
        actionStr = (actionStr.substring(0, 1).toUpperCase(Locale.ROOT) + actionStr.substring(1))
                .replace("_", " ");
        // 1?: switch не дает подставить Spellconsts.toString в case (constant expression required),
        //     if/elif - позволяет -- почему?
        // 2?: есть ли более изящный способ обработать заклинания (обойти Spellconsts по одинаковому сценарию?...)
        if (actionStr.equals("Атака")) {
            ((Attacking) acting).attack(target);
        } else if (actionStr.equals(Spellconsts.CURE.toString())) {
            ((Spellcasting) acting).prepareSpell(Spellconsts.CURE, target).cast();
        } else if (actionStr.equals(Spellconsts.THUNDER.toString())) {
            ((Spellcasting) acting).prepareSpell(Spellconsts.THUNDER, target).cast();
        } else if (actionStr.equals(Spellconsts.THUNDER_CHAIN.toString())) {
            ((Spellcasting) acting).prepareSpell(Spellconsts.THUNDER_CHAIN, target).cast();
        } else if (actionStr.equals(Spellconsts.WALL_OF_FIRE.toString())) {
            ((Spellcasting) acting).prepareSpell(Spellconsts.WALL_OF_FIRE, target).cast();
        } else if (actionStr.equals(Spellconsts.FIRE_TOUCH.toString())) {
            ((Spellcasting) acting).prepareSpell(Spellconsts.FIRE_TOUCH, target).cast();
        } else if (actionStr.equals(Spellconsts.MONSTER_BANISHING.toString())) {
            ((Spellcasting) acting).prepareSpell(Spellconsts.MONSTER_BANISHING, target).cast();
        } else if (actionStr.equals(Spellconsts.MIGRAINE.toString())) {
            ((Spellcasting) acting).prepareSpell(Spellconsts.MIGRAINE, target).cast();
        } else {
            System.out.println(acting.getName() + " не знает как делать " + actionStr + " по " + target.getName());
        }
    }

    public void processCurrentTurn() {
        System.out.println("Ход " + turn);
        System.out.println();
        System.out.println(scene.sceneView());
        for (Char c: scene.getChars()) {
            System.out.printf("Очередь %s: ", c.getName());
            String actionStr = scanner.next();
            String targetName = scanner.next();
            Char target = scene.findCharByName(targetName);
            try {
                claimAction(c, target, actionStr);
            }
            catch (NullPointerException e) {
                System.out.printf("%s устал, пока искал %s, но так и не нашел его...", c.getName(), targetName);
            }
            System.out.println();
        }
        scene.process();
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println();
        turn++;
    }

    public void start() {
        System.out.println();
        System.out.println();
        while (scene.getChars().length > 1)
            processCurrentTurn();
        if (scene.getChars().length == 1) {
            int winnerPos = IntStream.range(0, scene.getFields().length)
                    .filter(i -> scene.getFields()[i] != null)
                    .findFirst()
                    .orElse(-1);
            System.out.printf("%s %s победил!\n",
                    scene.getFields()[winnerPos].getCharClass(),
                    scene.getFields()[winnerPos].getName());
        } else
            System.out.println("Все погибли - победителей нет!");
    }

    public static Game createRandomGame(int magesCount, int monsterCount, int paladinCount) {
        Scene randomGameScene = new Scene();

        for (int i = 0; i < magesCount; i++)
            new MageBuilder()
                    .setScene(randomGameScene)
                    .setScenePos(randomGameScene.nextRandomFreePos())
                    .setName("Маг"+i)
                    .setSpellbook(Mage.randomSpellbook())
                    .createMage();

        for (int i = 0; i < monsterCount; i++)
            new MonsterBuilder()
                    .setScene(randomGameScene)
                    .setScenePos(randomGameScene.nextRandomFreePos())
                    .setName("Мнс"+i)
                    .createMonster();

        for (int i = 0; i < paladinCount; i++)
            new PaladinBuilder()
                    .setScene(randomGameScene)
                    .setScenePos(randomGameScene.nextRandomFreePos())
                    .setName("Пал"+i)
                    .createPaladin();

        return new Game(randomGameScene);
    }

    public static void check() {
        Scene middleEarth = new Scene();
        Monster urukHai = new MonsterBuilder()
                .setScene(middleEarth)
                .setScenePos(0)
                .setName("Урук-Хай")
                .createMonster();
        Mage gandalf = new MageBuilder()
                .setScene(middleEarth)
                .setScenePos(1)
                .setName("Гэндальф")
                .setSpellbook(List.of(Spellconsts.THUNDER, Spellconsts.THUNDER_CHAIN, Spellconsts.MONSTER_BANISHING))
                .createMage();
        Mage saruman = new MageBuilder()
                .setScene(middleEarth)
                .setScenePos(2)
                .setName("Саруман")
                .setSpellbook(List.of(Spellconsts.WALL_OF_FIRE, Spellconsts.FIRE_TOUCH, Spellconsts.MIGRAINE))
                .createMage();
        Paladin aragorn = new PaladinBuilder()
                .setScene(middleEarth)
                .setScenePos(3)
                .setName("Арагорн")
                .createPaladin();

        Game lotr = new Game(middleEarth);


        System.out.println();
        System.out.println();
        System.out.println("Тест монстра " + urukHai.getName() + ": ");

        System.out.println("  - атака:");
        lotr.claimAction(urukHai, gandalf, "атака");


        System.out.println();
        System.out.println("Тест мага " + gandalf.getName() + ": ");

        System.out.println("  - " + Spellconsts.THUNDER.toString() + ": ");
        lotr.claimAction(gandalf, aragorn, Spellconsts.THUNDER.toString());

        System.out.println("  - " + Spellconsts.THUNDER_CHAIN.toString() + ": ");
        lotr.claimAction(gandalf, null, Spellconsts.THUNDER_CHAIN.toString());

        System.out.println("  - " + Spellconsts.MONSTER_BANISHING.toString() + ": ");
        lotr.claimAction(gandalf, null, Spellconsts.MONSTER_BANISHING.toString());


        System.out.println();
        System.out.println("Тест мага " + saruman.getName() + ": ");

        System.out.println("  - " + Spellconsts.WALL_OF_FIRE.toString() + ": ");
        lotr.claimAction(saruman, null, Spellconsts.WALL_OF_FIRE.toString());

        System.out.println("  - " + Spellconsts.FIRE_TOUCH.toString() + ": ");
        lotr.claimAction(saruman, null, Spellconsts.FIRE_TOUCH.toString());

        System.out.println("  - " + Spellconsts.MIGRAINE.toString() + ": ");
        lotr.claimAction(saruman, null, Spellconsts.MIGRAINE.toString());


        System.out.println();
        System.out.println("Тест паладина " + aragorn.getName() + ": ");

        System.out.println("  - атака:");
        lotr.claimAction(aragorn, urukHai, "атака");

        System.out.println("  - " + Spellconsts.CURE.toString() + ": ");
        lotr.claimAction(aragorn, aragorn, Spellconsts.CURE.toString());

        System.out.println();
        System.out.println("Обход персонажей");
        lotr.scene.process();

    }

    public Game(Scene scene) {
        this.scene = scene;
    }
}
