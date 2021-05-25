package lesson4.character;

import com.orion.lesson4.spell.Spell;
import com.orion.lesson4.spell.SpellCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Mage extends Charm {

    private static final int MAX_SPELL_COUNT = 2;
    private static final int HITPOINT = 4;
    private ArrayList<Spell> spellBook = new ArrayList<>();

    public Mage(String name) {
        super("Маг №" + name, HITPOINT);
        generateSpellBook();
    }

    public void setDamage(int damage) {
        this.setHitPoint(this.getHitPoint() - damage);

    }

    public void action(Charm[] targets) {

        if(this.getHitPoint() > 0){

            Spell spell = getRandomSpell();
            System.out.println(this .getName() +  " читает заклинание " + spell.getName());

            spell.cast(this, targets);
        }

    }

    private void generateSpellBook() {

        ArrayList<SpellCollection> spells = new ArrayList<SpellCollection>(Arrays.asList(SpellCollection.values()));
        Random rand = new Random();
        int spellCount;

        while (spells.size() > 0 && spellBook.size() <= MAX_SPELL_COUNT) {
            //WHY not -1
            spellCount = spells.isEmpty() ? 0 : rand.nextInt(spells.size());
            spellBook.add(spells.remove(spellCount).action());
        }
    }

    private Spell getRandomSpell(){
        return spellBook.get(rand.nextInt(spellBook.size()));
    }

}
