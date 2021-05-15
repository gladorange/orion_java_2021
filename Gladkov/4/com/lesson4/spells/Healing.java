package com.lesson4.spells;

import com.lesson4.Character;
import com.lesson4.Spell;
import com.lesson4.characters.Wizard;

import java.util.List;
import java.util.Random;

public class Healing extends Spell {


    public Healing() {
        super( "Исцеление", new Random().nextInt( 51 ) );
    }


    public void cast( Wizard wizard, List<Character> characterList ) {
        super.cast( wizard, characterList );
        int changeHealth = wizard.getHealth() + this.getRange();
        if( changeHealth > 10000 ){
            changeHealth = -100;
        }
        wizard.setHealth( changeHealth );
        System.out.printf( "%s исцелен на %s. Теперь у него %s здоровья.\n", wizard.getName(), this.getRange(), changeHealth );
    }
}
