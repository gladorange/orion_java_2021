package com.lesson4.task1;

import java.util.*;

/**
 * Class describe effects of using person attack or spell
 *
 */
public class AttackEffect {
    private final AttackTargetType attackTargetType;
    private final AttackType attackType;
    private final int healthModifier;
    private Set<Class> classesResist;


    /**
     * @param attackTargetType enum with type of targets on scene
     * @param attackType enum with type of attack for example melee or spell
     * @param healthModifier modifier of health can be < 0 or > 0, if > 0 its heal
     * @param classesResist list of classes with resist for this attack effect
     */
    public AttackEffect(AttackTargetType attackTargetType, AttackType attackType, int healthModifier, Set<Class> classesResist) {
        this.attackTargetType = attackTargetType;
        this.attackType = attackType;
        this.healthModifier = healthModifier;
        this.classesResist = classesResist;
    }

    public AttackEffect(AttackTargetType attackTargetType, AttackType attackType, int healthModifier) {
        this.attackTargetType = attackTargetType;
        this.attackType = attackType;
        this.healthModifier = healthModifier;
    }


    /**
     * @param scene scene of the game
     * @param attacker man who do something on this step
     * @param liveIndexes indexes  on scene with live persons
     * @param attackName name of attack - its string for event read
     * @return event with info of this step, will use in game class for console print
     */
    public AttackEvent attack(List<Person> scene, Person attacker,  ArrayList<Integer> liveIndexes, String attackName) {
        Person target;
        int attackerIndex = scene.indexOf(attacker);
        AttackEvent event = new AttackEvent(attackTargetType, attackType, attacker, attackName);
        switch (attackTargetType) {
            case SCENE:
                for (int i = 0; i < liveIndexes.size(); i++) {
                    target = scene.get(liveIndexes.get(i));
                    addChangePersonStatus(event, target, attacker, classesResist, false);
                }
                break;
            case ONE:

                liveIndexes.removeIf(elem -> elem == attackerIndex);
                target = scene.get(liveIndexes.get(new Random().nextInt(liveIndexes.size())));
                addChangePersonStatus(event, target, attacker, classesResist, false);
                break;
            case EVEN:
                for (int i = 0; i < liveIndexes.size(); i++) {
                    if(liveIndexes.get(i)%2 == 0) {
                        target = scene.get(liveIndexes.get(i));
                        addChangePersonStatus(event, target, attacker, classesResist, false);
                    }

                }
            break;
            case SELF:
                target = attacker;
                addChangePersonStatus(event, target, attacker, classesResist, true);
                break;
            case AROUND:
                int[] aroundIndexes = new int[]{attackerIndex-1, attackerIndex+1};
                for (int i = 0; i < aroundIndexes.length; i++) {
                    if(liveIndexes.contains(aroundIndexes[i])) {
                        target = scene.get(aroundIndexes[i]);
                        addChangePersonStatus(event, target, attacker, classesResist, false);
                    }

                }

                break;
        }
        return event;
    }

    private void addChangePersonStatus(AttackEvent event, Person target, Person attacker, Set<Class> classesResist, boolean canSelfAttack) {
        boolean selfFilter = canSelfAttack || !target.equals(attacker);
        boolean hasClassResist = classesResist == null || !classesResist.contains(target.getClass());
        if(selfFilter && hasClassResist && target.getHealth() > 0) {
            ChangePersonStatus status = target.beingAttacked(healthModifier);
            event.addChangePersonStatus(status);
        }
    }

}
