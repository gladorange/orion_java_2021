package Task5;

import java.util.List;
import java.util.Random;

public class ExpulsionMonstersSpell extends Spell
{
    public ExpulsionMonstersSpell()
    {
        super("Изгнание монстров", new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1);
    }

    @Override
    public void cast(Character mainCharacter, List<Character> characters)
    {
        int numberMonsters = 0;
        for (var character : characters)
        {
            if (character instanceof Monster)
            {
                character.reduceHealth(score);
                ++numberMonsters;
            }
        }

        if (numberMonsters > 0)
        {
            System.out.printf("Нанесен урон всем монстрам в количестве %d единиц.\n", score);
        }
        else
        {
            System.out.println("Монстры на сцене кроме " + mainCharacter.getName() + " не обнаружены.");
        }
    }
}
