package com.task4.core.Char;

import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Template.Spellcasting;
import com.task4.core.Scene;
import com.task4.core.Spell.*;
import com.task4.core.Spell.Template.NullSpell;
import com.task4.core.Spell.Template.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Mage extends Char implements Spellcasting {
    public static final int MAX_HP = 50;
    private static final int SPELLBOOK_SIZE = 3;
    private static String charClass = "Маг";
    private List<Spellconsts> spellbook;

    public Mage(int hp, String name, Scene scene, int scenePos, List<Spellconsts> spellbook) {
        super(hp, name, scene, scenePos, charClass);
        System.out.printf("  Заклинания %s: %s\n",
                name,
                spellbook.stream()
                        .map(Spellconsts::toString)
                        .collect(Collectors.toList())
                        .toString()
        );
        if (!validateSpellbookSize(spellbook))
            throw new ArrayIndexOutOfBoundsException("Маг не может знать больше " + SPELLBOOK_SIZE + " заклинаний (подано " + spellbook.size() + ")");
        if (!validateSpellbookContent(spellbook))
            throw new IllegalArgumentException("Маг не может использовать одно из предложенных заклинаний (" + spellbook.toString() + ")");
        this.spellbook = spellbook;
    }

    private Mage() {
        this.spellbook = List.of(Spellconsts.CURE);
    }

    public static List<Spellconsts> randomSpellbook() {
        Random random = new Random();
        Mage mage = new Mage();
        List<Spellconsts> generatedSpellbook = new ArrayList<>();

        for (int i = 0; i < SPELLBOOK_SIZE; i++) {
            // TODO: явно можно сдлать лучше
            Spellconsts randomPickedSpell = mage.getAvailableSpells()
                    .get(random.nextInt(mage.getAvailableSpells().size()));
            while (generatedSpellbook.contains(randomPickedSpell))
                randomPickedSpell = mage.getAvailableSpells()
                        .get(random.nextInt(mage.getAvailableSpells().size()));
            generatedSpellbook.add(randomPickedSpell);
        }
        return generatedSpellbook;
    }

    @Override
    public Spell prepareSpell(Spellconsts spell, Char target) {
        if (!isInSpellbook(spell))
            System.out.printf("%s не знает заклинания \"%s\"\n", getName(), spell.toString());
        return switch (spell) {
            case CURE              -> new CureSpell(this, target);
            case THUNDER           -> new ThunderSpell(this, target);
            case THUNDER_CHAIN     -> new ThunderChainSpell(this, target);
            case WALL_OF_FIRE      -> new WallOfFireSpell(this, target);
            case FIRE_TOUCH        -> new FireTouchSpell(this, target);
            case MONSTER_BANISHING -> new MonsterBanishingSpell(this, target);
            default                -> new NullSpell(this, target);
        };
    }

    @Override
    public boolean isInSpellbook(Spellconsts spell) {
        return spellbook.contains(spell);
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    @Override
    public List<Spellconsts> getAvailableSpells() {
        /*
         по идее метод д.б. статичным, т.к. список допустимых заклинаний
         одинаков для любого экземпляра мага, но если объявить в Spellcasting
         метод как static, то в нем же потребуется реализация, а она варируется
         в зав-ти от класса
        */
        return List.of(Spellconsts.CURE,
                       Spellconsts.THUNDER,
                       Spellconsts.THUNDER_CHAIN,
                       Spellconsts.WALL_OF_FIRE,
                       Spellconsts.FIRE_TOUCH,
                       Spellconsts.MONSTER_BANISHING,
                       Spellconsts.MIGRAINE);
    }

    public boolean validateSpellbookSize(List<Spellconsts> spellbook) {
        return spellbook.size() <= SPELLBOOK_SIZE;
    }

    @Override
    public boolean validateSpellbookContent(List<Spellconsts> spellbook) {
        return getAvailableSpells().containsAll(spellbook);
    }

}
