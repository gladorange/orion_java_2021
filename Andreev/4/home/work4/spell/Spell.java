package home.work4.spell;

public class Spell {

    private SpellType spellType;
    private int power;

    public Spell(SpellType spellType) {
        this.spellType = spellType;
        this.power = getRandomPower();
    }

    private int getRandomPower() {
        return (int) (Math.random() * (70 - 10) + 10);
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public int cast() {
        return power;
    }
}
