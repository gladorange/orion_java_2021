package com.lesson4.task1;

import java.util.ArrayList;

public class AttackEvent {
    private ArrayList<ChangePersonStatus> changeList = new ArrayList<>();
    private AttackTargetType attackTargetType;
    private AttackType attackType;
    private String attackName;
    private Person attacker;

    public AttackEvent(AttackTargetType attackTargetType, AttackType attackType, Person attacker, String attackName) {
        this.attackTargetType = attackTargetType;
        this.attackType = attackType;
        this.attackName = attackName;
        this.attacker = attacker;
    }

    public AttackTargetType getAttackTargetType() {
        return attackTargetType;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public String getAttackName() {
        return attackName;
    }

    public ArrayList<ChangePersonStatus> getChangeList() {
        return changeList;
    }
    public void addChangePersonStatus(ChangePersonStatus status) {
        changeList.add(status);
    }

    public Person getAttacker() {
        return attacker;
    }
}
