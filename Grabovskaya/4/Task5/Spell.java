package Task5;

import java.util.List;

public abstract class Spell
{
    final static protected int MAX_AMOUNT_DAMAGE = 15;

    final protected String spellName; // название заклинания
    final protected int score; // на сколько очков изменяем здоровье персонажа

    public Spell(String spellName, int score)
    {
        this.spellName = spellName;
        this.score = score;
    }

    public String getSpellName()
    {
        return spellName;
    }

    public int getScore()
    {
        return score;
    }

    public abstract void cast(Character mainCharacter, List<Character> characters);
}
