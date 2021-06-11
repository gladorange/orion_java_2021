package homework10;

import homework10.classes.Animal;
import homework10.classes.Person;
import homework10.classes.Transport;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Person person = new Person("Vasya",12.0,"password");
        Animal animal = new Animal();
        Transport transport = new Transport();
        List<Object> list = new ArrayList<>();
        list.add(person);
        list.add(animal);
        list.add(transport);
        App app = new App();
        String result = app.serialize(list);
        System.out.println(result);
        StringBuilder sb = new StringBuilder();
        sb.append("<Человек>\n" +
                "    <Имя>Vasya</Имя>\n" +
                "    <Возраст>12</Возраст>\n" +
                "</Человек>");
        System.out.println(app.deserialize(sb.toString(),Person.class));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<Транспорт>\n" +
                "    <Модель>Порш Каен</Модель>\n" +
                "    <Максимальная скорость>260</Максимальная скорость>\n" +
                "    <Спортивная>true</Спортивная>\n" +
                "</Транспорт>");
        System.out.println(app.deserialize(sb2.toString(),Transport.class));
    }
}
