package home.work4.spell;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum SpellType {

    HEALING("Исцеление"),
    LIGHTNING("Молния"),
    CHAIN_ZIPPER("Цепная молния"),
    WALL_OF_FIRE("Стена огня"),
    FIERY_TOUCH("Огненное касание"),
    EXPULSION_OF_MONSTERS("Изгнание монстров"),
    MIGRAINE("Мигрень");

    private static final List<SpellType> VALUES = Arrays.asList(values());

    public static SpellType randomSpell() {
        return VALUES.get(new Random().nextInt(VALUES.size()));
    }

    private String tittle;

    SpellType(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

}
