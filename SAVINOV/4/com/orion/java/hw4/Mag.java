package com.orion.java.hw4;

import java.util.*;

public class Mag extends Character {
    private List<Spell> spellBook;
    private int countSpellsInBook;

    public Mag(String nameMag, int healthPoint, int countSpellsInBook) {
        super(nameMag, healthPoint);
        this.countSpellsInBook = countSpellsInBook;
        setSpellBook();
    }

    private void setSpellBook() {
        spellBook = new ArrayList<>();
        List<SpellsType> spellsTypeList = Arrays.asList(SpellsType.values());
        while (spellBook.size() <= countSpellsInBook) {
            Spell spell = new Spell(spellsTypeList.get(new Random().nextInt(spellsTypeList.size())));
            if (checkContainInSpellBook(spellBook, spell)) {
                spellBook.add(spell);
            }
        }
    }

    private boolean checkContainInSpellBook(List<Spell> spellBook, Spell spell) {
        long count = spellBook.stream()
                .filter(currentSpell -> Objects.equals(currentSpell.getTypeSpell(), spell.getTypeSpell()))
                .count();
        return count == 0;
    }

    @Override
    public void move(List<Character> characterList) {
        Spell spell = spellBook.get(new Random().nextInt(countSpellsInBook));
        int power = spell.getTypeSpell().getPower();
        int becameHP;
        Character character;
        switch (spell.getTypeSpell()) {
            case HEALING:
                spell.cast(this);
                this.setHealthPoint(this.getHealthPoint() + power);
                System.out.println(this.getNameCharacter() + " поправил своё здоровьице на: " + power + ". HP: " + this.getHealthPoint());
                break;
            case LIGHTNING:
                spell.cast(this);
                int random;
                do {
                    random = new Random().nextInt(characterList.size());
                    character = characterList.get(random);
                } while (!character.isAlive());
                becameHP = character.getHealthPoint() - spell.getTypeSpell().getPower();
                character.setHealthPoint(becameHP);
                character.checkAlive();
                System.out.println(this.getNameCharacter() + " HP: " + this.getHealthPoint() + " попал по " + character.getNameCharacter() + " HP: " + character.getHealthPoint() + " и нанес урон: " + power);
                printInfo(character);
                break;
            case CHAIN_LIGHTNING:
                spell.cast(this);
                System.out.println(this.getNameCharacter() + " наносит всем живым урон: " + power);
                for (int i = 0; i < characterList.size(); i++) {
                    character = characterList.get(i);
                    if (!character.getNameCharacter().equals(this.getNameCharacter()) && character.isAlive()) {
                        character.setHealthPoint(character.getHealthPoint() - power);
                        character.checkAlive();
                        printInfo(character);
                    }
                }
                break;
            case WALL_OF_FIRE:
                spell.cast(this);
                System.out.println(this.getNameCharacter() + " наносит урон: " + power);
                for (int i = 0; i < characterList.size(); i++) {
                    character = characterList.get(i);
                    if (i % 2 == 0 && character.isAlive()) {
                        character.setHealthPoint(character.getHealthPoint() - power);
                        character.checkAlive();
                        printInfo(character);
                    }
                }
                break;
            case FIERY_TOUCH:
                spell.cast(this);
                int position = this.getPosition() - 1;
                if (position > 0 && position < characterList.size()) {
                    character = characterList.get(position);
                    if (character.isAlive()) {
                        becameHP = character.getHealthPoint() - power;
                        character.setHealthPoint(becameHP);
                        System.out.printf("%s наносит %d", this.getNameCharacter(), becameHP);
                        character.checkAlive();
                        printInfo(character);
                    }
                }
                position = this.getPosition() + 1;
                if (position < characterList.size()) {
                    character = characterList.get(position);
                    if (character.isAlive()) {
                        character.setHealthPoint(character.getHealthPoint() - power);
                        System.out.printf("%s наносит урон: %d", this.getNameCharacter(), power);
                        character.checkAlive();
                        printInfo(character);
                    }
                }
                break;
            case EXPELLING_MONSTERS:
                spell.cast(this);
                System.out.println(this.getNameCharacter() + " наносит урон: " + power);
                for (int i = 0; i < characterList.size(); i++) {
                    character = characterList.get(i);
                    if (character instanceof Monster && character.isAlive()) {
                        character.setHealthPoint(character.getHealthPoint() - power);
                        character.checkAlive();
                        printInfo(character);
                    }
                }
                break;
            case MIGRAINE:
                spell.cast(this);
                System.out.println(this.getNameCharacter() + " наносит урон: " + power);
                for (int i = 0; i < characterList.size(); i++) {
                    character = characterList.get(i);
                    if (character instanceof Mag && character.isAlive()) {
                        character.setHealthPoint(character.getHealthPoint() - power);
                        character.checkAlive();
                        printInfo(character);
                    }
                }
                break;
            default: {
                System.out.println(this.getNameCharacter() + " не знает такого заклинания " + spell.getTypeSpell());
            }
        }
    }

    private void printInfo(Character character) {
        if (character.isAlive()) {
            System.out.println(character.getNameCharacter() + " HP: " + character.getHealthPoint());
        } else {
            System.out.println(character.getNameCharacter() + " погибает");
        }
    }
}