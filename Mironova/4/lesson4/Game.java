package lesson4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    public static Scanner in = new Scanner(System.in);
    public static Scene scene;

    public static void startTheGame() {

        System.out.println("Введите количество магов (1-10): ");
        int mageCount = in.nextInt();

        System.out.println("Введите количество монстров от 1 до : " + (Scene.SCENE_SIZE - mageCount));
        int monsterCount = in.nextInt();

        scene = new Scene(mageCount, monsterCount);

        System.out.println("Наблюдайте за игрой!");

        while (!haveAWinner()) {
            for (int i = 0; i < scene.SCENE_SIZE; i++) {
                if (scene.charms[i] != null) {
                    scene.charms[i].action(scene.charms);
                }
            }
            scene.clear();
        }

        getTheWinner();
    }

    private static boolean haveAWinner() {

        int nullElements = Collections.frequency(Arrays.asList(scene.charms), null);
        return (scene.SCENE_SIZE - nullElements) == 1;

    }

    private static void getTheWinner() {

        Arrays.asList(scene.charms).forEach(item -> {
            if (item != null) {
                System.out.println("\nВ игре побеждает " + item.getName() + "!!\n");
            }
        });
    }

}
