package com.task4.core.Char;

import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Template.Attacking;
import com.task4.core.Char.Template.Spellcasting;
import com.task4.core.Scene;
import com.task4.core.Spell.*;
import com.task4.core.Spell.Template.NullSpell;
import com.task4.core.Spell.Template.Spell;

import java.util.List;

public class Paladin extends Char
        implements Spellcasting, Attacking {
    public static final int MAX_HP            = 140;
    private static final int DMG              = 20;
    private static final double DAMAGE_RESIST = 0.5;
    private static final int SPELLBOOK_SIZE   = 1;
    private final List<Spellconsts> spellbook = List.of(Spellconsts.CURE);
    private static String charClass = "Паладин";

    public Paladin(int hp, String name, Scene scene, int scenePos) {
        super(hp, name, scene, scenePos, charClass);
    }

    @Override
    public void sufferDmg(int dmg) {
        dmg = (int)Math.ceil(DAMAGE_RESIST*dmg);
        super.sufferDmg(dmg);
    }

    @Override
    public int getDmg() {
        return DMG;
    }

    @Override
    public void attack(Char target) {
        if (!checkCanInteractWith(target)) {
            System.out.printf("%s пытался найти %s, чтобы атаковать его, но так и не нашел\n", getName(), target.getName());
            return;
        }
        int dealtDmg = getDmg();
        target.sufferDmg(dealtDmg);
        System.out.printf("%s наносит %d урона по %s\n", getName(), dealtDmg, target.getName());
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    @Override
    public List<Spellconsts> getAvailableSpells() {
        return spellbook;
    }

    @Override
    public boolean isInSpellbook(Spellconsts spell) {
        return spell.name().equals(Spellconsts.CURE.name());
    }

    @Override
    public boolean validateSpellbookContent(List<Spellconsts> spellbook) {
        return getAvailableSpells().containsAll(spellbook);
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
}
