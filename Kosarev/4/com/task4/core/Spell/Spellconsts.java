package com.task4.core.Spell;

/**
 * Пул всех доступных заклинаний
 */
public enum Spellconsts {
    CURE("Исцеление"),
    THUNDER("Молния"),
    THUNDER_CHAIN("Цепная молния"),
    WALL_OF_FIRE("Стена огня"),
    FIRE_TOUCH("Огненное прикосновение"),
    MONSTER_BANISHING("Изгнание монстров"),
    MIGRAINE("Мигрень");

    private String str;
    Spellconsts(String name) {
        str = name;
    }

    @Override
    public String toString() {
        return str;
    }
}
