package com.lesson4;

import com.lesson4.characters.Monster;
import com.lesson4.spells.*;
import com.lesson4.characters.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Scene {
    private final List<Character> characterList = new ArrayList<>();

    private final  Monster [] arrayMonsters = {
            new Monster( 100,"Скелет",10 ),
            new Monster( 120,"Живой мертвец",25 ),
            new Monster( 150,"Вампир",35 ),
            new Monster( 180, "Лич", 40 ),
            new Monster( 220,"Чёрный рыцарь", 60 ),
            new Monster( 300,"Костяной дракон",80 )
            };

    private final Wizard [] arrayWizards = {
            new Wizard( 100, "Целитель",  new Healing() ),
            new Wizard( 120,"Колдун", new Thunderbolt() ),
            new Wizard( 150, "Волшебник", new ChainLightning(), new Thunderbolt() ),
            new Wizard( 180, "Чародей", new FireTouch(), new WallFire() ),
            new Wizard( 220, "Магистр", new Healing(), new FireTouch(), new WallFire() ),
            new Wizard( 300, "Архимаг", new Healing(), new ExileMonsters(), new Migraine() )
    };


    public Scene() {
        //Генерация случайного списка персонажей
        for( int i = 0; i < 10; i++ ){
            int randomNumber = new Random().nextInt(3);
            if( randomNumber > 0 ){
                if ( ( randomNumber > 1 ) ) {
                    Monster monster = arrayMonsters[ new Random().nextInt( arrayMonsters.length ) ];
                    Monster newMonster = new Monster( monster.getHealth(), monster.getName() , monster.getDamage() );
                    newMonster.setPosition( i );
                    characterList.add( newMonster );
                } else {
                    Wizard wizard = arrayWizards[ new Random().nextInt( arrayWizards.length ) ];
                    Wizard newWizard = new Wizard( wizard.getHealth(), wizard.getName() , wizard.getBookSpells() );
                    newWizard.setPosition( i );
                    characterList.add( newWizard );
                }
            } else { characterList.add( null ); }
        }
    }


    public void startGame(){
        while ( true ){
            List<Character> list = characterList.stream()
                    .filter( Objects::nonNull )
                    .collect( Collectors.toList() );

            if( list.size() == 1 ){
                Character character = list.get( 0 );
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.printf( "Игра окончена. Победу одержал %s %s. \n", character.getName(), character.getType() );
                break;
            }

            for ( Character character : characterList ){
                if( character != null ){
                    character.isDead( characterList );
                    if( character instanceof Wizard ){
                        ( (Wizard) character).castSpell( characterList );
                    } else {
                        ( (Monster) character).attack( characterList );
                    }
                }
            }
        }
    }

}
