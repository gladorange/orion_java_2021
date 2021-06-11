package Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Person { " + "name = '" + name + '\'' +
                ", age = " + age + " }";
    }

    public static void main(String[] args)
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Валера", 46));
        persons.add(new Person("Ирина", 25));
        persons.add(new Person("Евгений", 32));
        persons.add(new Person("Алексей", 27));
        persons.add(new Person("Светлана", 38));

        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("Сортировка по имени:");
        persons.forEach(person -> System.out.println(person));

        Collections.sort(persons, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("Сортировка по возрасту:");
        persons.forEach(person -> System.out.println(person));
    }
}
