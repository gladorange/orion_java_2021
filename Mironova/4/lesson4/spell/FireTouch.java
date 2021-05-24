package lesson4.spell;

import com.orion.lesson4.character.Charm;

import java.util.Arrays;

public class FireTouch extends Spell{

    private static int DAMAGE = 4;

    public FireTouch(String name) {
        super(name, DAMAGE);
    }

    @Override
    public void cast(Charm player, Charm[] targets) {

        int playerIndex = Arrays.asList(targets).indexOf(player);

        if(Arrays.asList(targets).get(playerIndex - 1) != null){
            this.getMessage(targets[playerIndex - 1].getName());
            targets[playerIndex - 1].setDamage(DAMAGE);
        }

        if(Arrays.asList(targets).get(playerIndex + 1) != null){
            this.getMessage(targets[playerIndex + 1].getName());
            targets[playerIndex + 1].setDamage(DAMAGE);
        }

    }
}
