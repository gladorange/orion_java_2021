package Task5;

import java.util.*;
import java.util.stream.Collectors;

public class BattleMages
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>();
        names.add("Василий");
        names.add("Володя");
        names.add("Пётр");
        names.add("Руслан");
        names.add("Иннокентий");
        names.add("Олег");
        names.add("Виктор");
        names.add("Валера");
        names.add("Виталий");
        names.add("Борис");

        final int numberOfPositions = 10; // количество позиций на сцене
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < numberOfPositions; i++)
        {
            positions.add(i);
        }

        Random random = new Random();
        final int numberOfDifferentCharacters = 2;
        final int numberOfCharacters = random.nextInt(numberOfPositions) + 1; // кол-во персонажей на сцене
        List<Character> sceneWithCharacters = new LinkedList<>();
        // Заполняем сцену персонажами
        for (int i = 0; i < numberOfCharacters; i++)
        {
            int position = positions.remove(random.nextInt(positions.size())); // берем любую позицию из 10-ти
            String name = names.remove(random.nextInt(names.size()));
            switch (random.nextInt(numberOfDifferentCharacters))
            {
                case 0:
                    sceneWithCharacters.add(new Monster(name, position, 30));
                    break;
                case 1:
                    sceneWithCharacters.add(new Mage(name, position, 30));
                    break;
            }
        }

        if (sceneWithCharacters.size() == 1)
        {
            System.out.println("Создался всего 1 персонаж.");
            return;
        }

        while (sceneWithCharacters.size() > 1)
        {
            Character currentCharacter = sceneWithCharacters.get(random.nextInt(sceneWithCharacters.size()));
            currentCharacter.performAction(sceneWithCharacters
                    .stream()
                    .filter(character -> currentCharacter != character)
                    .collect(Collectors.toList()));

            if (sceneWithCharacters.removeIf(character -> character.getCurrentHealth() < 0))
            {
                System.out.println("Количество оставшихся персонажей: " + sceneWithCharacters.size());
            }
        }
        System.out.println("Игра закончена.");
    }
}
