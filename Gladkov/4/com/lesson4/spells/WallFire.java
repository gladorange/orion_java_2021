package com.lesson4.spells;

import com.lesson4.Character;
import com.lesson4.Spell;
import com.lesson4.characters.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WallFire extends Spell {


    public WallFire() {
        super("Стена огня", new Random().nextInt( 16 ) );
    }


    public void cast( Wizard wizard, List<Character> characterList ) {
        List<String> nameCharacter = new ArrayList<>();
        super.cast( wizard, characterList );
        characterList.stream()
                .skip(2)
                .filter( character -> character != null && !character.equals( wizard ) && characterList.indexOf( character )%2 == 0 )
                .map( character -> character.setHealth( character.getHealth() - this.getRange() ) )
                .forEach( character -> nameCharacter.add( character.getName() ) );
        if( nameCharacter.size() > 0 ){
            System.out.printf( "Стена огня ударяет по %s. Каждый получает %s урона.\n", nameCharacter, this.getRange() );
        }
    }
}
