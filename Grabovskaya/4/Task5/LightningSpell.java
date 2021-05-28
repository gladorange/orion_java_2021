package Task5;

import java.util.AbstractMap;
import java.util.List;
import java.util.Random;

public class LightningSpell extends Spell
{
    public LightningSpell()
    {
        super("Молния", new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1);
    }

    @Override
    public void cast(Character mainCharacter, List<Character> characters)
    {
        Character victim = characters.get(new Random().nextInt(characters.size()));
        System.out.printf("Молния ударила по %s. Персонаж получил %d единиц урона.\n", victim.getName(), score);
        victim.reduceHealth(score);
    }
}
