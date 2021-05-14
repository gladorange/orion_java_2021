package com.lesson4.spells;

import com.lesson4.Spell;
import com.lesson4.characters.Wizard;
import com.lesson4.Character;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Thunderbolt extends Spell {


    public Thunderbolt() {
        super( "Молния", new Random().nextInt( 61 ) );
    }


    public void cast( Wizard wizard, List<Character> characterList ) {
        super.cast( wizard, characterList );
        Character character;

        do {
            int randomIndex = new Random().nextInt( characterList.size() );
            if( characterList.stream().filter( Objects::nonNull ).count() == 1 ){
                character = characterList.stream().filter( Objects::nonNull )
                        .collect( Collectors.toList() ).get( 0 );
                break;
            }
            character = characterList.get( randomIndex );
        } while ( character == null || character.equals( wizard ) );

        int changeHealth = character.getHealth() - this.getRange();
        character.setHealth( changeHealth );
        character.isDead( characterList );
        System.out.printf( "Молния ударяет по %s. Он получает %s урона. Теперь у него %s здоровья.\n", character.getName(),
                this.getRange(), changeHealth );
    }
}
