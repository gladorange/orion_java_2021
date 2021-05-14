package home.work4.character;

import home.work4.spell.SpellType;
import home.work4.util.ConsoleHelper;

import java.util.List;
import java.util.Random;

public class Monster extends Character {

    private int power;

    public Monster(int health, String name) {
        super(health, name);
        this.power = getRandomPower();
    }

    @Override
    public void attack(List<Character> characterList) {
        ConsoleHelper.showMessage("Монстр " + this.getName() + " атакует!");
        int position = new Random().nextInt(characterList.size());
        if (characterList.get(position).isAlive() & characterList.get(position) != this) {
            characterList.get(position).setHealth(characterList.get(position).getHealth() - power);
            ConsoleHelper.showMessage("Персонаж " + characterList.get(position).getName() + " получает урон " + power + ". Осталось здоровья " + characterList.get(position).getHealth() + ".");
            checkAlive(characterList.get(position));
        } else {
            ConsoleHelper.showMessage("Монстр " + this.getName() + " промазал.");
        }
        if (characterList.get(position).getHealth() <= 0) {
            characterList.get(position).setAlive(false);
        }
    }

    private int getRandomPower() {
        return (int) (Math.random() * (50 - 15) + 15);
    }
}
