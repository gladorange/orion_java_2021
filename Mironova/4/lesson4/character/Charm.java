package lesson4.character;

import java.util.Random;

abstract public class Charm {

    public Random rand = new Random();

    private String name;
    private int hitPoint;

    public Charm(String name, int hitPoint) {
        this.name = name;
        this.hitPoint = hitPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public abstract void setDamage(int damage);

    public abstract void action(Charm[] targets);


}
