package com.task4.core.Spell;

import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Template.Spellcasting;
import com.task4.core.Spell.Template.Spell;

public class ThunderSpell extends Spell {
    private static final int DMG = 15;

    public ThunderSpell(Spellcasting caster, Char target) {
        super(Spellconsts.THUNDER.toString(), caster, target);
    }

    @Override
    public void cast() {
        super.cast();
        getTarget().sufferDmg(DMG);
        System.out.printf("Удар молнии прошел по %s\n",
                getTarget().getName());
    }
}
