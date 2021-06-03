package Task5;

import java.util.List;
import java.util.Random;

public class MigraineSpell extends Spell
{
    public MigraineSpell()
    {
        super("Мигрень", new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1);
    }

    @Override
    public void cast(Character mainCharacter, List<Character> characters)
    {
        int numberMages = 0;
        for (var character : characters)
        {
            if (character instanceof Mage)
            {
                character.reduceHealth(score);
                ++numberMages;
            }
        }

        if (numberMages > 0)
        {
            System.out.printf("Мигрень нанесла урон вышеуказанным магам, забрав у каждого %d очков жизни.\n", score);
        }
        else
        {
            System.out.println("Маги на сцене кроме " + mainCharacter.getName() + " не обнаружены.");
        }
    }
}
