package Task5;

import java.util.List;
import java.util.Random;

public class HealingSpell extends Spell
{
    public HealingSpell()
    {
        super("Исцеление", new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1);
    }

    @Override
    public void cast(Character mainCharacter, List<Character> characters)
    {
        mainCharacter.addHealth(score);
        System.out.printf("Маг %s исцелен на %d. Теперь у него %d здоровья.\n", mainCharacter.getName(), score, mainCharacter.getCurrentHealth());
    }
}
