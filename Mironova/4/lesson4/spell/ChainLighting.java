package lesson4.spell;

import com.orion.lesson4.character.Charm;

public class ChainLighting extends Spell{

    private static int DAMAGE = 5;

    public ChainLighting(String name) {
        super(name, DAMAGE);
    }

    @Override
    public void cast(Charm player, Charm[] targets) {

        for (Charm target: targets) {
            if(target != null && !this.equals(target)){
                this.getMessage(target.getName());
                target.setDamage(DAMAGE);
            }
        }
    }



}
