package com.orion.lesson10;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }



    static class BoxedPerson {
        Box<String> name;
        Box<Integer> age;

        public BoxedPerson(Box<String> name, Box<Integer> age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {


        Box<Person> box = new Box<>(null);

        final Class<BoxedPerson> boxedPersonClass = BoxedPerson.class;


        printName(boxedPersonClass);
        printAge(boxedPersonClass);


    }

    private static void printName(Class<BoxedPerson> boxedPersonClass) throws NoSuchFieldException {
        final Field rawField = boxedPersonClass.getDeclaredField("name");
        final Type field = rawField.getGenericType();

        if (field instanceof ParameterizedType) {
            System.out.println(rawField.getType() + ":" + Arrays.toString(((ParameterizedType) field).getActualTypeArguments()));
        }
    }
    private static void printAge(Class<BoxedPerson> boxedPersonClass) throws NoSuchFieldException {
        final Field rawField = boxedPersonClass.getDeclaredField("age");
        final Type field = rawField.getGenericType();

        if (field instanceof ParameterizedType) {
            System.out.println(rawField.getType() + ":" + Arrays.toString(((ParameterizedType) field).getActualTypeArguments()));
        }
    }
}
