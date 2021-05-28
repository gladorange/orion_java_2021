package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.function.Supplier;

public class Mage extends Character
{
    final static private int MAX_NUMBER_SPELLS = 3;

    List<Spell> spellBook;

    public Mage(String name, int position, int currentHealth)
    {
        super(name, position, currentHealth);

        List<Supplier<? extends Spell>> allSpells = new ArrayList<>();
        allSpells.add(HealingSpell::new);
        allSpells.add(LightningSpell::new);
        allSpells.add(ChainLightningSpell::new);
        allSpells.add(WallFireSpell::new);
        allSpells.add(FireTouchSpell::new);
        allSpells.add(ExpulsionMonstersSpell::new);
        allSpells.add(MigraineSpell::new);

        Random random = new Random();
        spellBook = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBER_SPELLS; i++)
        {
            spellBook.add(allSpells.remove(random.nextInt(allSpells.size())).get());
        }

        StringJoiner sj = new StringJoiner(", ");
        spellBook.forEach(spell -> sj.add(spell.getSpellName()));

        System.out.printf("Добавлен маг %s на позиции %d со списком заклинаний: %s.\n", name, position, sj.toString());
    }

    @Override
    public void performAction(List<Character> sceneWithoutThisCharacter) // колдовать заклинания
    {
        Spell spell = spellBook.get(new Random().nextInt(spellBook.size()));
        System.out.println("\nМаг " + name + " читает заклинание '" + spell.getSpellName() + "'.");
        spell.cast(this, sceneWithoutThisCharacter);
    }
}
