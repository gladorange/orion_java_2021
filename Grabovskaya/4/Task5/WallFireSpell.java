package Task5;

import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class WallFireSpell extends Spell
{
    public WallFireSpell()
    {
        super("Стена огня",new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1);
    }

    @Override
    public void cast(Character character, List<Character> characters)
    {
        StringJoiner sj = new StringJoiner(", ");
        for (var someCharacter : characters)
        {
            if (someCharacter.getPosition() % 2 == 0)
            {
                someCharacter.reduceHealth(score);
                sj.add("(" + someCharacter.getName() + ", " + someCharacter.getPosition() + ")");
            }
        }
        System.out.printf("Стена огня ударила по %s. Персонажы получили %d единиц урона.\n", sj.toString(), score);
    }
}
