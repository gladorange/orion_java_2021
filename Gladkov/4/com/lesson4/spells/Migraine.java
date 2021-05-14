package com.lesson4.spells;

import com.lesson4.Character;
import com.lesson4.Spell;
import com.lesson4.characters.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Migraine extends Spell {


    public Migraine( ) {
        super( "Мигрень", new Random().nextInt( 55 ) );
    }


    public void cast( Wizard wizard, List<Character> characterList ) {
        List<String> nameCharacter = new ArrayList<>();
        super.cast( wizard, characterList );
        characterList.stream()
                .filter( character -> character instanceof Wizard && !character.equals( wizard )  )
                .map( character -> character.setHealth( character.getHealth() - this.getRange() ) )
                .forEach( character -> nameCharacter.add( character.getName() ) );

        if( nameCharacter.size() > 0 ){
            System.out.printf( "Мигрень ударяет по %s. Каждый получает %s урона.\n", nameCharacter, this.getRange() );
        }
    }
}
