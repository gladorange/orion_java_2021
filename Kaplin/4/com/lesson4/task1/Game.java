package com.lesson4.task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    private final int SCENE_SIZE = 10;
    private ArrayList<Integer> liveIndexes;
    private List<Person> scene;
    private int steps = 0;


    public Game(Person[] persons) {
        Person[] scene = new Person[SCENE_SIZE];
        int maxPersonsCount;
        int randomSize = new Random().nextInt(SCENE_SIZE);
        maxPersonsCount = randomSize < 2 ? randomSize + 2 : randomSize;
        ArrayList<Integer> nullPlaces = new ArrayList<>();
        for(int i = 0; i < SCENE_SIZE - persons.length; i++) {
            nullPlaces.add(new Random().nextInt(SCENE_SIZE));
        }
        for (int i = 0; i < maxPersonsCount; i++) {
            if(i > persons.length - 1 || nullPlaces.contains(i)) {
                scene[i] = null;
            } else {
                scene[i] = persons[i];
            }

        }

        this.scene = new ArrayList<Person>(Arrays.asList(scene));
        liveIndexes = countLivePersons();

    }


    public void run () {
        boolean finished = false;
        while(!finished) {
            steps++;
            System.out.println("Ход " + steps);
            for (Person person: scene) {
                if(person != null && person.getHealth() > 0) {
                    eventReader(person.attack(scene, liveIndexes));
                }
                liveIndexes = countLivePersons();
                finished = liveIndexes.size() <= 1;
                if(finished) {
                    String victoryMessage = liveIndexes.size() == 1 ?
                    scene.get(liveIndexes.get(0)).toString() + " победил " : "Все умерли, какая досада";
                    System.out.println(victoryMessage);
                    break;
                }
            }
        }
    }

    private ArrayList<Integer> countLivePersons() {
        ArrayList<Integer> livePersons = new ArrayList<>();
        for (int i = 0; i < SCENE_SIZE; i++) {
            if(scene.get(i) != null && scene.get(i).getHealth() > 0) {
                livePersons.add(i);
            } else {
                scene.set(i, null);
            }
        }
        return livePersons;
    }

    /** this method print in console result of attack
     * @param event its event from attack method in AttackEffect class
     */
    private void eventReader(AttackEvent event) {
        if(event == null) {
            throw new NullPointerException("event cant be a null, please override attack method in person class");
        }
        StringBuilder afterAttackMessage = new StringBuilder();
        String attackTypeString;
        switch (event.getAttackType()) {
            case SPELL:
                attackTypeString = "кастует " + event.getAttackName();
            break;
            case MELEE:
                attackTypeString = "атакует " + event.getAttackName();
            break;
            default:
                attackTypeString = "использует что-то";
        }
        String attackerString = event.getAttacker().getName() + " " +  attackTypeString + "\n";
        afterAttackMessage.append(attackerString);
        for(ChangePersonStatus status : event.getChangeList()) {
            String statusString;
            if(status.isDead()) {
                statusString = status.getName() + " убит, ";
            } else {
                int healthModifier = status.getHealthModifier();
                if(healthModifier == 0) {
                    statusString = "С " + status.getName() + " ничего не происходит, ";
                } else {
                    String healthString = healthModifier < 0 ? "получает " + (-1 * healthModifier) + " урона " :
                            "вылечен на " + healthModifier;
                    statusString = status.getName() + " " + healthString + " теперь его здоровье " + status.getResultHealth() + ", ";
                }


            }
            afterAttackMessage.append(statusString);

        }
        System.out.println(event.getChangeList().size() == 0 ? afterAttackMessage.toString() + "Никто не пострадал" : afterAttackMessage.toString());
    }



}
