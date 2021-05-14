package com.task4.core.Spell;

import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Template.Spellcasting;
import com.task4.core.Spell.Template.Spell;

public class CureSpell extends Spell {
    private static final int HEAL_HP = 20;

    public CureSpell(Spellcasting caster, Char target) {
        super(Spellconsts.CURE.toString(), caster, target);
    }

    @Override
    public void cast() {
        super.cast();
        getTarget().setHp(getTarget().getHp() + HEAL_HP );
        if (getTarget().equals(getCaster()))
            System.out.printf("%s лечит себя. Здоровье %s: %d\n", getTarget().getName(), getTarget().getName(), getTarget().getHp());
        else
            System.out.printf("%s лечит %s. Здоровье %s: %d\n",
                    ((Char) getCaster()).getName(),
                    getTarget().getName(),
                    getTarget().getName(),
                    getTarget().getHp());
    }
}
