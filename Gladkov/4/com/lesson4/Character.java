package com.lesson4;

import java.util.List;
import java.util.Objects;

public abstract class Character {
    private int health;
    private String name;
    private final String type;


    public Character( int health, String name, String type ) {
        this.health = health;
        this.name = name;
        this.type = type;
    }


    public int getHealth() {
        return health;
    }

    public Character setHealth( int health ) {
        this.health = health;
        return this;
    }

    public String getName() {
        return name;
    }

    public Character setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public boolean isDead( List<Character>characterList ){
        if( this.health < 0 ){
            System.out.printf( "%s убит\n",this.getName() );
            characterList.set( characterList.indexOf( this ), null );
        }
        return this.health < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return health == character.health &&
                Objects.equals(name, character.name) &&
                Objects.equals(type, character.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, name, type);
    }
}
