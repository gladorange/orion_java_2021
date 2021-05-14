package home.work4.character;

import java.util.List;

public abstract class Character {

    private int health;
    private String name;
    private boolean isAlive;

    public Character(int health, String name) {
        this.health = health;
        this.name = name;
        this.isAlive = true;
    }

    public abstract void attack(List<Character> characterList);

    void checkAlive(Character character) {
        if (character.getHealth() <= 0) {
            character.setAlive(false);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
