package com.lesson4.characters;

import com.lesson4.Character;
import com.lesson4.Spell;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Wizard extends Character {
    private Spell[] bookSpells;
    private int position;


    public Wizard( int health, String name, Spell ... bookSpells ) {
        super( health, name, "Маг" );
        this.bookSpells = bookSpells;
    }


    public Spell[] getBookSpells() {
        return bookSpells;
    }

    public Wizard setPosition( int position ) {
        this.position = position;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public void castSpell(List<Character> characterList ){
        int randomSpell = new Random().nextInt( this.bookSpells.length );
        Spell spell = this.bookSpells[ randomSpell ];
        spell.cast( this, characterList );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wizard wizard = (Wizard) o;
        return position == wizard.position &&
                Arrays.equals(bookSpells, wizard.bookSpells);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), position);
        result = 31 * result + Arrays.hashCode(bookSpells);
        return result;
    }
}
