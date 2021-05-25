package lesson4.spell;

import com.orion.lesson4.character.Charm;

public class Lighting extends Spell{

    private static int DAMAGE = 7;

    public Lighting(String name) {
        super(name, DAMAGE);
    }

    @Override
    public void cast(Charm player, Charm[] targets) {

        for (Charm target: targets) {
            if(target != null && !this.equals(target)){
                getMessage(target.getName());
                target.setDamage(DAMAGE);
                break;
            }
        }

    }

}
