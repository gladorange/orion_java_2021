package lesson4.spell;

import com.orion.lesson4.character.Charm;

public class Spell {

    private String name;
    private int damage;

    public Spell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void cast(Charm player, Charm[] targets){
        System.out.println("Кастую рандомное заклинание");
    };

    public void getMessage(String targetName){
        System.out.println(this.getName() + " ударяет по " + targetName);
        System.out.println(targetName + " получает " + this.getDamage() + " урона.");
    }

}
