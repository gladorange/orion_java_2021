package com.task4.core.Spell;

import com.task4.core.Char.Char;
import com.task4.core.Char.Spellcasting;

public class NullSpell extends Spell {
    public NullSpell(Spellcasting caster, Char target) {
        super("", caster, target);
    }

    @Override
    public void cast() {
    }
}
