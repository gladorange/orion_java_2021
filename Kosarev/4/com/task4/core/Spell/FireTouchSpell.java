package com.task4.core.Spell;

import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Template.Spellcasting;
import com.task4.core.Spell.Template.Spell;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FireTouchSpell extends Spell {
    private static final int DMG = 50;

    public FireTouchSpell(Spellcasting caster, Char target) {
        super(Spellconsts.FIRE_TOUCH.toString(), caster, target);
    }

    @Override
    public void cast() {
        super.cast();
        Char cCaster = (Char) getCaster();
        Arrays.stream(cCaster.getScene().getChars())
                .filter(c -> (
                        c.getScenePos() == cCaster.getScenePos() - 1 ||
                        c.getScenePos() == cCaster.getScenePos() + 1))
                .forEach(c -> c.sufferDmg(DMG));
        System.out.printf("%s нанесла %s по %d урона\n",
                getName(),
                Arrays.stream(cCaster.getScene().getChars())
                        .filter(c -> (
                                c.getScenePos() == cCaster.getScenePos() - 1 ||
                                c.getScenePos() == cCaster.getScenePos() + 1))
                        .map(Char::getName)
                        .collect(Collectors.toList())
                        .toString(),
                DMG);
    }
}
