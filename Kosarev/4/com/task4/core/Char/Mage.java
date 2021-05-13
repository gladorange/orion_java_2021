package com.task4.core.Char;

import com.task4.core.Scene;
import com.task4.core.Spell.CureSpell;
import com.task4.core.Spell.NullSpell;
import com.task4.core.Spell.Spell;

import java.util.List;

public class Mage extends Char implements Spellcasting {
    public static final int MAX_HP = 50;
    private static final int SPELLBOOK_SIZE = 3;
    private List<String> spellbook;

    public Mage(int hp, String name, Scene scene, int scenePos, List<String> spellbook) {
        super(hp, name, scene, scenePos);
        if (!validateSpellbookSize(spellbook))
            throw new ArrayIndexOutOfBoundsException("Маг не может знать больше " + SPELLBOOK_SIZE + " заклинаний (подано " + spellbook.size() + ")");
        if (!validateSpellbookContent(spellbook))
            throw new IllegalArgumentException("Маг не может использовать одно из предложенных заклинаний (" + spellbook.toString() + ")");
        this.spellbook = spellbook;
    }

    private boolean validateSpellbookSize(List<String> spellbook) {
        return spellbook.size() <= SPELLBOOK_SIZE;
    }

    private boolean validateSpellbookContent(List<String> spellbook) {
        return getAvailableSpells().containsAll(spellbook);
    }

    @Override
    public Spell prepareSpell(String spellName, Char target) {
        if (!isInSpellbook(spellName))
            System.out.printf("%s не знает заклинания \"%s\"\n", getName(), spellName);
        return switch (spellName) {
            case "Исцеление" -> new CureSpell(this, target);
            default          -> new NullSpell(this, target);
        };
    }

    @Override
    public boolean isInSpellbook(String spellName) {
        return spellbook.contains(spellName);
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    @Override
    public String toSceneView() {
        return "Mage";
    }

    @Override
    public List<String> getAvailableSpells() {
        /*
         по идее метод д.б. статичным, т.к. список допустимых заклинаний
         одинаков для любого экземпляра мага, но если объявить в Spellcasting
         метод как static, то в нем же потребуется реализация, а она варируется
         в зав-ти от класса
        */
        // TODO: поменять на enum-ы?
        return List.of(
                "Исцеление",
                "Молния",
                "Цепная молния",
                "Стена огня",
                "Огненное касание",
                "Изгнание монстров",
                "Мигрень");
    }

    @Override
    public boolean isSpellAllowed(String spellName) {
        return getAvailableSpells().contains(spellName);
    }
}
