package com.lesson10.task1;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        ObjectWorkerWithJSON JSONWorker = new ObjectWorkerWithJSON();
        List<Person> persons = Arrays.asList(
                new Person("Vasya", false),
                new Person("Kolya", false),
                new Person("Dima", true),
                new Person("Anna", true)
        );


        String serialized = JSONWorker.serialize(persons);
        System.out.println(serialized);
        List<Person> personsAfterSerialize = JSONWorker.deserialize(serialized, Person.class );
        System.out.println(personsAfterSerialize);
    }
}
