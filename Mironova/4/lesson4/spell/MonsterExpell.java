package lesson4.spell;

import com.orion.lesson4.character.Charm;
import com.orion.lesson4.character.Monster;

public class MonsterExpell extends Spell{

    private static int DAMAGE = 5;

    public MonsterExpell(String name) {
        super(name, DAMAGE);
    }

    @Override
    public void cast(Charm player, Charm[] targets) {

        for (Charm target: targets) {
            if(target != null && target instanceof Monster){
                getMessage(target.getName());
                target.setDamage(DAMAGE);
            }
        }

    }
}
