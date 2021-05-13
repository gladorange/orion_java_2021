package com.task4.core.Char;

import com.task4.core.Spell.Spell;
import java.util.List;


public interface Spellcasting {
    List<String> getAvailableSpells();
    boolean isSpellAllowed(String spellName);
    boolean isInSpellbook(String spellName);
    Spell prepareSpell(String spellName, Char target);
}
