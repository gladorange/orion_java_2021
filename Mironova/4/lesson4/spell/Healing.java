package lesson4.spell;

import com.orion.lesson4.character.Charm;

public class Healing extends Spell{

    private static int DAMAGE = -7;

    public Healing(String name) {
        super(name, DAMAGE);
    }

    @Override
    public void cast(Charm player, Charm[] targets) {
        this.getMessage(player.getName());
        player.setDamage(DAMAGE);
    }

    @Override
    public void getMessage(String targetName){
        System.out.println(targetName + " исцелён на " + (this.getDamage() * -1)  + " здоровья");
    }
}
