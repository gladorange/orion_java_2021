package home.work4;

import home.work4.character.Character;
import home.work4.util.ConsoleHelper;
import home.work4.util.Util;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ConsoleHelper.showMessage("Игра началась!");
        List<Character> list = Util.createCharacters(10);
        while (Util.checkPlayers(list)){
            for (int i=0;i<list.size();i++){
                if (list.get(i).isAlive()) {
                    list.get(i).attack(list);
                }
            }
        }
        Util.getWinner(list);
    }
}
