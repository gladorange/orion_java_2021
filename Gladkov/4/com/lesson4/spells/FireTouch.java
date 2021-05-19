package com.lesson4.spells;

import com.lesson4.Character;
import com.lesson4.Spell;
import com.lesson4.characters.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FireTouch extends Spell {


    public FireTouch() {
        super( "Огненное касание", new Random().nextInt( 76 ) );
    }

     
    public void cast( Wizard wizard, List<Character> characterList ) {
        List<String> nameCharacter = new ArrayList<>();
        super.cast( wizard, characterList );
        int indexWizard = characterList.indexOf( wizard );
        boolean flag = true;

        if( indexWizard == 0 && characterList.get( indexWizard + 1 ) != null){
            Character character =  characterList.get( indexWizard + 1 );
            character.setHealth( character.getHealth() - this.getRange() );
            characterList.set( indexWizard + 1, character );
            nameCharacter.add( character.getName() );
            System.out.printf( "Огненное касание ударяет по %s. Каждый получает %s урона.\n", nameCharacter, this.getRange() );
            flag = false;
        }

        if( indexWizard == characterList.size() - 1  && characterList.get( indexWizard - 1 ) != null){
            Character character =  characterList.get( indexWizard - 1 );
            character.setHealth( character.getHealth() - this.getRange() );
            characterList.set( indexWizard - 1, character );
            nameCharacter.add( character.getName() );
            System.out.printf( "Огненное касание ударяет по %s. Каждый получает %s урона.\n", nameCharacter, this.getRange() );
            flag = false;
        }

        if( indexWizard > 0 && indexWizard != characterList.size() - 1 ){
            if( characterList.get( indexWizard + 1 ) != null ){
                Character character =  characterList.get( indexWizard + 1 );
                character.setHealth( character.getHealth() - this.getRange() );
                characterList.set( indexWizard + 1, character );
                nameCharacter.add( character.getName() );
            }
            if( characterList.get( indexWizard - 1 ) != null ){
                Character character =  characterList.get( indexWizard - 1 );
                character.setHealth( character.getHealth() - this.getRange() );
                characterList.set( indexWizard - 1, character );
                nameCharacter.add( character.getName() );
            }
            flag = false;
            if( nameCharacter.size() > 0 ) {
                System.out.printf("Огненное касание ударяет по %s. Каждый получает %s урона.\n", nameCharacter, this.getRange());
            } else { flag = true; }
        }
        if( flag ) {
            System.out.println( "Огненное касание не нанесло урона.");
        }
    }

}
