package com.task4.core.Spell.Template;

import com.task4.core.Char.Template.Char;
import com.task4.core.Char.Template.Spellcasting;

public class NullSpell extends Spell {
    public NullSpell(Spellcasting caster, Char target) {
        super("", caster, target);
    }

    @Override
    public void cast() {
    }
}
