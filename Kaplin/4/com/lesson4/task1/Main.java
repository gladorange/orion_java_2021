package com.lesson4.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Spell heal = new Spell("Исцеление", AttackTargetType.SELF,  4);
        Spell thunder = new Spell("Молния", AttackTargetType.ONE,  -4);
        Spell chainThunder = new Spell("Цепная молния", AttackTargetType.SCENE,  -4);
        Spell fireWall = new Spell("Стена огня", AttackTargetType.EVEN,  -5);
        Spell fireTouch = new Spell("Огненное касание", AttackTargetType.AROUND,  -7);
        Spell exileMonster = new Spell("Изгнание монстров", AttackTargetType.SCENE,  -3, Set.of(Mage.class));
        Spell migraine = new Spell("Мигрень", AttackTargetType.SCENE,  -3, Set.of(Monster.class));


        Mage electro = new Mage("Электроник",  20, new SpellBook(List.of(thunder, chainThunder, exileMonster)));
        Mage fireMan = new Mage("Жук пожарник", 20, new SpellBook(List.of(heal, fireTouch, fireWall)));
        Mage badMan = new Mage("Неприятный человек", 10, new SpellBook(List.of(migraine, heal, fireWall)));
        Mage oldMan = new Mage("Старый маг", 20, new SpellBook(List.of(heal, thunder, fireWall)));
        Mage stupidMan = new Mage("Тупой мг", 10, new SpellBook(List.of(migraine, heal, exileMonster)));
        Monster buffy = new Monster("Бафамет", 15, -10);
        Monster lilith = new Monster("Лилит", 20, -4);
        Monster jaga = new Monster("Яга", 15, -6);
        Monster fat = new Monster("Жир", 30, -1);
        Monster dex = new Monster("Проныра", 20, -8);

        Game game = new Game(new Person[]{electro,  fireMan, badMan, buffy, oldMan, stupidMan, lilith, jaga, fat, dex});
        game.run();

    }
}
