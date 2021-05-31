package Task7;

import java.util.List;
import java.util.Random;

public class Animal
{
    protected String name;
    protected String typeAnimal;

    public Animal(String name, String typeAnimal)
    {
        this.name = name;
        this.typeAnimal = typeAnimal;
    }

    public String getName() { return name; }

    public String getTypeAnimal() { return typeAnimal; }

    public static void feedAnimals(List<Pair<Animal,String>> animals)
    {
        for (Pair<Animal, String> animal : animals)
        {
            System.out.printf("%s %s с радостью съедает %s\n", animal.getFirst().getTypeAnimal(), animal.getFirst().getName(), animal.getSecond());
        }

        var pair = animals.get(new Random().nextInt(animals.size()));
        System.out.printf("Счастливое животное %s получает двойную порцию %s\n", pair.getFirst().getName(), pair.getSecond());
    }
}
