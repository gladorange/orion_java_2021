package com.orion.lesson10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class XmlSerializer {



    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface SecretField {

    }



    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface XmlFieldName {

        String value() default "";



    }


    static class Animal {

        @XmlFieldName("Name")
        private String name;

        @SecretField
        private String favoriteDish;

        public Animal(String name, String favoriteDish) {
            this.name = name;
            this.favoriteDish = favoriteDish;
        }
    }


    public static void main(String[] args) throws IllegalAccessException {


        Person p = new Person("Vasya", "Pupkin", 18);

        p.setPassword("secret");
        /**
         * <Person>
         *     <Name>Vasya</Name>
         *     <LastName>Pupkin</LastName>
         *     <Age>18</Age>
         * </Person>
         */


        System.out.println(serialize(p));
        System.out.println(serialize(new Animal("Barsik","Milk")));
    }



    static String serialize(Object object) throws IllegalAccessException {
        final Class<?> aClass = object.getClass();
        StringBuilder sb = new StringBuilder("<"+ aClass.getSimpleName() +">\n");

        for (Field declaredField : aClass.getDeclaredFields()) {

            if (declaredField.isAnnotationPresent(SecretField.class)) {
                continue;
            }

            declaredField.setAccessible(true);
            final String fieldName = getName(declaredField);
            sb.append("<" + fieldName + ">" + declaredField.get(object) + "</"+fieldName+">\n");
        }

        sb.append("</" + aClass.getSimpleName() + ">\n");

        return sb.toString();
    }

    private static String getName(Field declaredField) {
        final XmlFieldName annotation = declaredField.getAnnotation(XmlFieldName.class);

        if (annotation != null) {
            return annotation.value();
        }
        return declaredField.getName();
    }
}
