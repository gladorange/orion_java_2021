package com.orion.lesson10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ObtainingClass {


    public static void main(String[] args) throws
            ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchFieldException,
            NoSuchMethodException,
            InvocationTargetException {


        final Class<Person> aClass = (Class<Person>) Class.forName("com.orion.lesson10.Person");
        final Object person = aClass.newInstance();


        final Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(declaredFields.length);


        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName()+":" + declaredField.getType());

            declaredField.setAccessible(true);

            if (CharSequence.class.isAssignableFrom(declaredField.getType())) {
                declaredField.set(person, "vasya");
            }

            if (Modifier.isPrivate(declaredField.getModifiers())) {
                System.out.println("Приватное");
            }

        }



        aClass.getField("someNumber").set(null, 43);


        aClass.getDeclaredMethod("setAge", int.class).invoke(person, 18);

        

        System.out.println(Person.someNumber);
        System.out.println(person);


    }
}
