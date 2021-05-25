package lesson4;

import com.orion.lesson4.character.Charm;
import com.orion.lesson4.character.Mage;
import com.orion.lesson4.character.Monster;

import java.util.Random;

public class Scene {

    final static int SCENE_SIZE = 10;
    public Charm[] charms = new Charm[SCENE_SIZE];

    public Scene(int mageCount, int monsterCount) {

        for (int i = 1; i <= mageCount; i++) {
            charms[getFreePoint()] = new Mage(String.valueOf(i));
        }

        for (int i = 1; i <= monsterCount; i++) {
            charms[getFreePoint()] = new Monster(String.valueOf(i));
        }

    }

    public void clear(){

        /*int nullElements = Collections.frequency(Arrays.asList(scene.charms), null);
        return (scene.SCENE_SIZE - nullElements) == 1;*/


        for (int i = 0; i < SCENE_SIZE; i++) {
            if(charms[i] != null && charms[i].getHitPoint() <= 0){
                charms[i] = null;
            }
        }

   /*     //TODO лямбда
        for (Charm item: charms) {
            if(item != null && item.getHitPoint() <= 0){
                item = null;
            }
        }*/
    }

    private int getFreePoint(){

        Random rand = new Random();
        int freePoint = rand.nextInt(SCENE_SIZE - 1);

        while (charms[freePoint] != null){
            freePoint = rand.nextInt(SCENE_SIZE - 1);
        }

        return freePoint;
    }

}
