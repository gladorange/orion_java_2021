package Task5;

import java.util.List;
import java.util.Random;

public class ChainLightningSpell extends Spell
{
    public ChainLightningSpell()
    {
        super("Цепная молния", new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1);
    }

    @Override
    public void cast(Character mainCharacter, List<Character> characters)
    {
        characters.forEach(character -> character.reduceHealth(score));
        System.out.printf("Цепная молния ударила по всем вышеуказанным персонажам на сцене, забрав у каждого %d очков жизни.\n", score);
    }
}
