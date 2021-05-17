package com.task4.core.Spell;

import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Monster;
import com.task4.core.Char.Template.Spellcasting;
import com.task4.core.Spell.Template.Spell;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MonsterBanishingSpell extends Spell {
    private static final int DMG = 10;

    public MonsterBanishingSpell(Spellcasting caster, Char target) {
        super(Spellconsts.MONSTER_BANISHING.toString(), caster, target);
    }

    @Override
    public void cast() {
        super.cast();
        Char cCaster = (Char) getCaster();
        Arrays.stream(cCaster.getScene().getChars())
                .filter(c -> c instanceof Monster)
                .forEach(c -> c.sufferDmg(DMG));
        System.out.printf("%s нанесла %s по %d урона\n",
                getName(),
                Arrays.stream(cCaster.getScene().getChars())
                        .filter(c -> c instanceof Monster)
                        .map(Char::getName)
                        .collect(Collectors.toList())
                        .toString(),
                DMG);
    }
}
