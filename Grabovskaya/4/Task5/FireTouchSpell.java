package Task5;

import java.util.List;
import java.util.Random;

public class FireTouchSpell extends Spell
{
    public FireTouchSpell()
    {
        super("Огненное касание", new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1);
    }

    @Override
    public void cast(Character mainCharacter, List<Character> characters)
    {
        int position = mainCharacter.getPosition();
        int neighborPosition = -1;
        Character neighbor = null;
        for (var character : characters)
        {
            if (character.getPosition() == (position - 1) || character.getPosition() == (position + 1))
            {
                neighborPosition = character.getPosition();
                neighbor = character;
                break;
            }
        }

        if (neighborPosition > -1)
        {
            System.out.printf("Огненное касание ударило по %s. Персонажы получили %d единиц урона.\n", neighbor.getName(), score);
            neighbor.reduceHealth(score);
        }
        else
        {
            System.out.println("У данного мага на соседних позициях персонажей нет.");
        }
    }
}
