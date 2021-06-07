package home.work8.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person("Ivan", 28));
        list.add(new Person("Max", 40));
        list.add(new Person("Eva", 34));
        list.add(new Person("Marry", 21));
        list.add(new Person("Alex", 19));

        Collections.sort(list,Comparator.comparing(Person::getName));

        System.out.println(list);

        Collections.sort(list,Comparator.comparing(Person::getAge));

        System.out.println(list);
    }
}
