package home.work4.util;

import home.work4.character.Character;
import home.work4.character.Mage;
import home.work4.character.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

    public static List<Character> createCharacters(int count) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(getRandomChar());
        }
        return list;
    }

    public static boolean checkPlayers(List<Character> list) {
        int count = 0;
        for (Character character : list) {
            if (character.isAlive()) {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }

        return false;
    }

    public static void getWinner(List<Character> list) {
        for (Character character : list) {
            if (character.isAlive()) {
                ConsoleHelper.showMessage("Победил " + character.getClass().getSimpleName() + " по имени " + character.getName() + ".");
            }
        }
    }

    private static Character getRandomChar() {
        int randomNumber = new Random().nextInt(2);
        switch (randomNumber) {
            case 0:
                return new Monster(130, getMonsterName());
            case 1:
                return new Mage(100, getCharName());
        }

        return null;
    }

    private static String getMonsterName() {
        List<String> list = Stream.of("Варг", "Боркак", "Маркараш", "Гарреннал", "Ксезоглаз", "Мальтаррун", "Канагор", "Гафидрак", "Мокмордран", "Грелинер").collect(Collectors.toList());
        return list.get(new Random().nextInt(list.size()));
    }

    private static String getCharName() {
        List<String> list = Stream.of("Лоийк", "Акакий", "Борис", "Генрих", "Марк", "Моргана", "Мерлин", "Гэндальф", "Радагаст", "Саурон").collect(Collectors.toList());
        return list.get(new Random().nextInt(list.size()));
    }
}
