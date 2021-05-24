package lesson4.spell;

import com.orion.lesson4.character.Charm;

public class WallOfFire extends Spell{

    private static int DAMAGE = 15;

    public WallOfFire(String name) {
        super(name, DAMAGE);
    }

    @Override
    public void cast(Charm player, Charm[] targets) {

        for (int i = 0; i < targets.length; i++) {
            if((i % 2) == 0){
                getMessage(targets[i].getName());
                targets[i].setDamage(DAMAGE);
            }
        }

    }
}
