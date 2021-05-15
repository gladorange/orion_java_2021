package com.lesson4.characters;

import com.lesson4.Character;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Monster extends Character {
    private int damage;
    private int position;


    public Monster( int health, String name, int damage ) {
        super( health, name,"Монстер" );
        this.damage = damage;
    }


    public int getDamage() {
        return damage;
    }

    public Monster setPosition(int position) {
        this.position = position;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public void attack(List<Character>characterList ){
        Character character;
        do {
            int randomIndex = new Random().nextInt( characterList.size() );
            if( characterList.stream().filter( Objects::nonNull ).count() == 1 ){
                character = characterList.stream().filter( Objects::nonNull )
                        .collect(Collectors.toList() ).get( 0 );
                break;
            }
            character = characterList.get( randomIndex );
        } while ( character == null || character.equals( this ) );
       System.out.printf( "Монстр %s атакует %s на %s единиц урона.\n", this.getName(), character.getName(), damage );
       character.setHealth( character.getHealth() - damage );
       character.isDead( characterList );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return damage == monster.damage &&
                position == monster.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damage, position);
    }
}
