package com.task4.core.Chars;

import com.task4.core.Scene.Field;
import com.task4.core.Scene.Scene;
import com.task4.core.SceneViewable;


public class Monster extends Char {
    private int dmg;

    public Monster(Scene scene, int pos, String name, int hp, int maxhp, int dmg) {
        super(scene, pos, name, hp, maxhp);
        this.dmg = dmg;
    }

    public void attack(int fieldId) {
        if (fieldId < 0 || fieldId > scene.getSceneSize()) {
            System.out.printf("%s ударил в открытый космос (%d) и промахнулся =(", name, fieldId);
            return;
        }
        Field fieldUnderAttack = scene.getFields()[fieldId];
        if (!(fieldUnderAttack.getContaining() instanceof Char)) {
            System.out.printf("%s ударил по пустому полю (%d) =(", name, fieldId);
            return;
        }
        Char unitAttacked = (Char) fieldUnderAttack.getContaining();
        unitAttacked.setHp(unitAttacked.getHp() - dmg);
    }

    @Override
    public String toSceneView() {
        return "Mnst";
    }
}
