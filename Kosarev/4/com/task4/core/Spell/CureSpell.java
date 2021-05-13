package com.task4.core.Spell;

import com.task4.core.Char.Char;
import com.task4.core.Char.Spellcasting;

public class CureSpell extends Spell {
    private static final int HEAL_HP = 20;

    public CureSpell(Spellcasting caster, Char target) {
        super("Исцеление", caster, target);
    }

    @Override
    public void cast() {
        super.cast();
//        Char cCaster = ((Char)getCaster());
//        cCaster.setHp(cCaster.getHp() + HEAL_HP);
//        System.out.printf("%s лечит себя. Здоровье %s = %d\n", cCaster.getName(), cCaster.getName(), cCaster.getHp());
        getTarget().setHp(getTarget().getHp() + HEAL_HP );
        if (getTarget().equals(getCaster()))
            System.out.printf("%s лечит себя. Здоровье %s = %d\n", getTarget().getName(), getTarget().getName(), getTarget().getHp());
        else
            System.out.printf("%s лечит %s. Здоровье %s = %d\n",
                    ((Char) getCaster()).getName(),
                    getTarget().getName(),
                    getTarget().getName(),
                    getTarget().getHp());
    }
}
