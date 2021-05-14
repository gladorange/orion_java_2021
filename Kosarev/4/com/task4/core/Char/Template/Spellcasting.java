package com.task4.core.Char.Template;

import com.task4.core.Spell.Template.Spell;
import com.task4.core.Spell.Spellconsts;

import java.util.List;


public interface Spellcasting {
    List<Spellconsts> getAvailableSpells();
    boolean isInSpellbook(Spellconsts spell);
    boolean validateSpellbookContent(List<Spellconsts> spellbook);
    Spell prepareSpell(Spellconsts spell, Char target);
}
