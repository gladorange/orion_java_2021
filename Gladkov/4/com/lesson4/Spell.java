package com.lesson4;

import com.lesson4.characters.Wizard;

import java.util.List;

public abstract class Spell {
    private String name;
    private int range;


    public Spell( String name, int range ) {
        this.name = name;
        this.range = range;
    }


    public int getRange() {
        return range;
    }

    public void cast( Wizard wizard, List<Character> characterList ){
        System.out.printf( "%s читает заклинание %s.\n", wizard.getName(), name );
    }
}
