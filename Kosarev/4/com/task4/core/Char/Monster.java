package com.task4.core.Char;

import com.task4.core.Scene;
import java.util.Random;


public class Monster extends Char {
    public static final int MAX_HP          = 100;
    private static final int BASE_DMG       = 20;
    private static final int DMG_DISPERSION = 5;    // TODO: add validation of fields

    private int getDmg() {
        int lowestDmg = BASE_DMG - DMG_DISPERSION;
        int highestDmg = BASE_DMG + DMG_DISPERSION;
        return new Random().nextInt(highestDmg - lowestDmg) + lowestDmg;
    }

    public void attack(Char target) {
        if (!checkCanInteractWith(target)) {
            System.out.printf("%s пытался найти %s, чтобы атаковать его, но так и не нашел\n", getName(), target.getName());
            return;
        }
        int dealtDmg = getDmg();
        target.setHp(target.getHp() - dealtDmg);
        System.out.printf("%s наносит %d урона по %s (%d)\n", getName(), dealtDmg, target.getName(), target.getHp());
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    @Override
    public String toSceneView() {
        return "Mnst";
    }

    public Monster(int hp, String name, Scene scene, int scenePos) {
        super(hp, name, scene, scenePos);
    }

}
