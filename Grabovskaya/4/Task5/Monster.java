package Task5;

import java.util.List;
import java.util.Random;

public class Monster extends Character
{
    final static private int MAX_AMOUNT_DAMAGE = 15;

    final private int amountOfDamage; // количество урона

    public Monster(String name, int position, int currentHealth)
    {
        super(name, position, currentHealth);
        amountOfDamage = new Random().nextInt(MAX_AMOUNT_DAMAGE) + 1;

        System.out.printf("Добавлен монстр %s на позиции %d.\n", name, position);
    }

    @Override
    public void performAction(List<Character> sceneWithoutThisCharacter) // атаковать
    {
        Character victim = sceneWithoutThisCharacter.get(new Random().nextInt(sceneWithoutThisCharacter.size()));
        System.out.println("\nМонстр " + name + " атакует " + victim.getName() + " на " + amountOfDamage + " единиц урона.");
        victim.reduceHealth(amountOfDamage);
    }
}
