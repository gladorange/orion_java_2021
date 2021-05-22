package lesson4.spell;

import com.orion.lesson4.character.Charm;
import com.orion.lesson4.character.Mage;

public class Migraine extends Spell{

    private static int DAMAGE = 2;

    public Migraine(String name) {
        super(name, DAMAGE);
    }

    @Override
    public void cast(Charm player, Charm[] targets) {

        for (Charm target: targets) {
            if(target != null && target instanceof Mage){
                getMessage(target.getName());
                target.setDamage(DAMAGE);
            }
        }

    }
}
