package com.task4;


import com.task4.core.Game;

import java.util.Scanner;

public class Main {
    private static int magesCount = 1;
    private static int monsterCount = 2;
    private static int paladinCount = 1;

    public static void printHelp() {
        System.out.println("В игре участвуют:");
        System.out.printf(" - %d магов \n", magesCount);
        System.out.printf(" - %d паладинов\n", paladinCount);
        System.out.printf(" - %d монстров\n", monsterCount);
        System.out.println("Формат ввода команды: %действие% %имя_цели%");
        System.out.println("Если действие не предполагает цель, то ввдоится любое %имя_цели% \n" +
                           "                               (напр. ненаправленное заклинание)");
        System.out.println("""
                Возможные действия:
                 - атака %имя_цели%
                 - исцеление %имя_цели%
                 - молния %имя_цели%
                 - цепная_молния (ненаправл.)
                 - стена_огня (ненаправл.)
                 - огненное_прикосновение (ненаправл.)
                 - изгнание_монстров (ненаправл.)
                 - мигрень (ненаправл.)
                """);
        System.out.println("Игра продолжается, до <= 1 выжившего");
        System.out.println();
        System.out.println("NOTE: персонажи погибнут только в конце хода. Сделанно намеренно, чтобы\n" +
                           "каждый персонаж сделал хотя бы один ход");
    }

    public static void printMenu() {
        System.out.println("Битва магов");
        System.out.println();
        System.out.println("1. Сыграть случайную битву");
        System.out.println("2. Тест персонажей");
        System.out.println("3. Помощь");
        System.out.println("0. Выход");
        System.out.println();
        System.out.print("> ");
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int sel = new Scanner(System.in).nextInt();
            switch (sel) {
                case 1 -> Game.createRandomGame(magesCount, monsterCount, paladinCount).start();
                case 2 -> Game.check();
                case 3 -> printHelp();
                case 0 -> exit=true;
            }
            System.out.println("-------------------------------------------");
            System.out.println();
        }
    }
}
