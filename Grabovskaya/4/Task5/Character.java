package Task5;

import java.util.List;
import java.util.Objects;

public abstract class Character
{
    final protected String name;
    final protected int position;
    protected int currentHealth;

    public Character(String name, int position, int currentHealth)
    {
        this.name = name;
        this.position = position;
        this.currentHealth = currentHealth;
    }

    public String getName()
    {
        return name;
    }

    public int getCurrentHealth()
    {
        return currentHealth;
    }

    public int getPosition()
    {
        return position;
    }

    public void setCurrentHealth(int currentHealth)
    {
        this.currentHealth = currentHealth;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        Character character = (Character) o;
        return Objects.equals(name, character.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }

    /*
    * Если в данный метод передавать еще и персонажа, который именно наносит урон,
    * то его можно будет переопределить для новых классов и написать в переопределенных
    * методах свою логику. Также и для метода addHealth().
    * К сожалению, получилось только вот так.
     */
    public void reduceHealth(int score)
    {
        currentHealth -= score;

        System.out.printf("Текущее здоровье (%s, %d): %d.\n", name, position, currentHealth);
        if (currentHealth < 0)
        {
            System.out.println(name + " убит.");
        }
    }

    public void addHealth(int score)
    {
        currentHealth += score;
        System.out.printf("Текущее здоровье (%s, %d): %d.\n", name, position, currentHealth);
    }

    public abstract void performAction(List<Character> sceneWithoutThisCharacter);
}
