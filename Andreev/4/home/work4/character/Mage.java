package home.work4.character;

import home.work4.spell.Spell;
import home.work4.spell.SpellType;
import home.work4.util.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mage extends Character {

    private List<Spell> spells;

    public Mage(int health, String name) {
        super(health, name);
        setSpells();
    }

    @Override
    public void attack(List<Character> characterList) {
        Spell spell = getRandomSpell();
        switch (spell.getSpellType()) {
            case HEALING:
                ConsoleHelper.showMessage("Маг " + this.getName() + " читает заклинание " + SpellType.HEALING.getTittle() + ".");
                this.setHealth(this.getHealth() + spell.cast());
                ConsoleHelper.showMessage("Маг " + this.getName() + " исцелен на " + spell.cast() + ". Теперь у него " + this.getHealth() + " здоровья");
                break;
            case LIGHTNING:
                ConsoleHelper.showMessage("Маг " + this.getName() + " читает заклинание " + SpellType.LIGHTNING.getTittle());
                int position = new Random().nextInt(characterList.size());
                if (characterList.get(position).isAlive()) {
                    characterList.get(position).setHealth(characterList.get(position).getHealth() - spell.cast());
                    checkAlive(characterList.get(position));
                    ConsoleHelper.showMessage("Молния ударяет в " + characterList.get(position).getName() + ". " + characterList.get(position).getName() + " получает " + spell.cast() + " урона.");
                } else {
                    ConsoleHelper.showMessage("Заклинание " + SpellType.LIGHTNING.getTittle() + " ударило в пустое место!");
                }
                break;
            case CHAIN_ZIPPER:
                ConsoleHelper.showMessage("Маг " + this.getName() + " читает заклинание " + SpellType.CHAIN_ZIPPER.getTittle() + ".");
                StringBuilder sb = new StringBuilder();
                for (Character character : characterList) {
                    if (character != this & character.isAlive()) {
                        sb.append(character.getName()).append(",").append(" ");
                        character.setHealth(character.getHealth() - spell.cast());
                        checkAlive(character);
                    }
                }
                if (sb.length() > 0) {
                    ConsoleHelper.showMessage("Молния ударяет в " + sb.substring(0, sb.lastIndexOf(", ")) + ". Каждый получает " + spell.cast() + " урона.");
                } else {
                    ConsoleHelper.showMessage("Заклинание " + SpellType.LIGHTNING.getTittle() + " никого не поразило!");
                }
                break;
            case WALL_OF_FIRE:
                ConsoleHelper.showMessage("Маг " + this.getName() + " читает заклинание " + SpellType.WALL_OF_FIRE.getTittle() + ".");
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < characterList.size(); i++) {
                    if (i % 2 == 0 & characterList.get(i).isAlive() & characterList.get(i) != this) {
                        str.append(characterList.get(i).getName()).append(",").append(" ");
                        characterList.get(i).setHealth(characterList.get(i).getHealth() - spell.cast());
                        checkAlive(characterList.get(i));
                    }
                }
                if (str.length() > 0) {
                    ConsoleHelper.showMessage("Стена огня поразила " + str.substring(0, str.lastIndexOf(", ")) + ". Каждый получает " + spell.cast() + " урона.");
                } else {
                    ConsoleHelper.showMessage("Заклинание " + SpellType.WALL_OF_FIRE.getTittle() + " никого не поразило!");
                }
                break;
            case FIERY_TOUCH:
                ConsoleHelper.showMessage("Маг " + this.getName() + " читает заклинание " + SpellType.FIERY_TOUCH.getTittle() + ".");
                int magePosition = -1;
                for (int i = 0; i < characterList.size(); i++) {
                    if (characterList.get(i) == this) {
                        magePosition = i;
                    }
                }
                if (magePosition != -1) {
                    if (magePosition != 0 & magePosition != characterList.size() - 1) {
                        attackNextTo(characterList.get(magePosition - 1), spell);
                        attackNextTo(characterList.get(magePosition + 1), spell);
                    } else {
                        if (magePosition == 0) {
                            attackNextTo(characterList.get(magePosition + 1), spell);
                        } else {
                            attackNextTo(characterList.get(magePosition - 1), spell);
                        }
                    }
                } else {
                    ConsoleHelper.showMessage("Заклинание " + SpellType.FIERY_TOUCH.getTittle() + " никого не поразило!");
                }
                break;
            case EXPULSION_OF_MONSTERS:
                ConsoleHelper.showMessage("Маг " + this.getName() + " читает заклинание " + SpellType.EXPULSION_OF_MONSTERS.getTittle() + ".");
                StringBuilder str1 = new StringBuilder();
                for (Character character : characterList) {
                    if (character instanceof Monster & character.isAlive()) {
                        character.setHealth(character.getHealth() - spell.cast());
                        str1.append(character.getName()).append(",").append(" ");
                        checkAlive(character);
                    }
                }
                if (str1.length() > 0) {
                    ConsoleHelper.showMessage("Изгнание монстров поразило " + str1.substring(0, str1.lastIndexOf(", ")) + ". Каждый получает " + spell.cast() + " урона.");
                } else {
                    ConsoleHelper.showMessage("Заклинание " + SpellType.EXPULSION_OF_MONSTERS.getTittle() + " никого не поразило!");
                }
                break;
            case MIGRAINE:
                ConsoleHelper.showMessage("Маг " + this.getName() + " читает заклинание " + SpellType.MIGRAINE.getTittle() + ".");
                StringBuilder str2 = new StringBuilder();
                for (Character character : characterList) {
                    if (character instanceof Mage & character.isAlive() & character != this) {
                        character.setHealth(character.getHealth() - spell.cast());
                        str2.append(character.getName()).append(",").append(" ");
                        checkAlive(character);
                    }
                }
                if (str2.length() > 0) {
                    ConsoleHelper.showMessage("Мигрень поразила " + str2.substring(0, str2.lastIndexOf(", ")) + ". Каждый получает " + spell.cast() + " урона.");
                } else {
                    ConsoleHelper.showMessage("Заклинание " + SpellType.MIGRAINE.getTittle() + " никого не поразило!");
                }
                break;
        }
    }

    private void attackNextTo(Character character, Spell spell) {
        if (character.isAlive()) {
            character.setHealth(character.getHealth() - spell.cast());
            ConsoleHelper.showMessage(spell.getSpellType().getTittle() + " поражает " + character.getName() + ". " + character.getName() + " получает " + spell.cast() + " урона.");
            checkAlive(character);
        }
    }

    private void setSpells() {

        spells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            spells.add(new Spell(SpellType.randomSpell()));
        }
    }

    private Spell getRandomSpell() {
        return spells.get(new Random().nextInt(3));
    }

    public List<Spell> getSpells() {
        return spells;
    }
}
