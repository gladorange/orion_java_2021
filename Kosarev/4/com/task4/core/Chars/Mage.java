package com.task4.core.Chars;

import com.task4.core.Scene.Scene;
import com.task4.core.Spells.Spell;


public class Mage extends Char {
    private Spell[] spellbook;

    public Mage(Scene scene, int pos, String name, int hp, int maxhp, Spell[] spellbook) {
        super(scene, pos, name, hp, maxhp);
        this.spellbook = spellbook;
    }

    @Override
    public String toSceneView() {
        return "Mage";
    }
}
