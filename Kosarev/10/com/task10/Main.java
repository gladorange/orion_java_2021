package com.task10;

import java.util.List;


public class Main {

    @Serializer.Typename("Пользователь")
    public static class User {
        @Serializer.Name("Логин")
        private final String username;
        @Serializer.Ignore
        private final String password;
        @Serializer.Name("Возраст")
        private final double age;
        @Serializer.Name("Оформил подписку")
        private final boolean annoyingSpamSubscribed;

        public User(String username, String password, double age, boolean annoyingSpamSubscribed) {
            this.username = username;
            this.password = password;
            this.age = age;
            this.annoyingSpamSubscribed = annoyingSpamSubscribed;
        }

        public User(String username, double age, boolean annoyingSpamSubscribed) {
            this(username, null, age, annoyingSpamSubscribed);
        }

        public User() {
            this(null, null, 0, false);
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", age=" + age +
                    ", annoyingSpamSubscribed=" + annoyingSpamSubscribed +
                    '}';
        }
    }


    @Serializer.Typename("Животное")
    public static class Pet {
        @Serializer.Name("Кличка")
        private final String name;
        @Serializer.Name("Возраст")
        private final int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Pet() {
            this(null, 0);
        }

        @Override
        public String toString() {
            return "Pet(" + name + "," + age + ')';
        }
    }


    public static void main(String[] args) {
        Serializer yamlSerializer = new YAMLSerializer();
        List<Object> usersToSerialize = List.of(
                new User( "Admin", "123qwe", 50, false),
                new User( "Alice", "weakPass", 23, true),
                new User( "Bob", "5tr0ngP@s5wOrd", 29, false)
        );
        List<Object> petsToSerialize = List.of(
                new Pet("Матроскин", 4),
                new Pet("Шарик", 3)
        );
        System.out.println("Созданы два списка объектов:");
        System.out.println(usersToSerialize);
        System.out.println(petsToSerialize);
        System.out.println();

        String usersYaml = yamlSerializer.serialize(usersToSerialize);
        String petsYaml = yamlSerializer.serialize(petsToSerialize);
        System.out.println("Сериализованные объекты:");
        System.out.println(usersYaml);
        System.out.println(petsYaml);

        List<User> usersUnyamled = yamlSerializer.deserialize(usersYaml, User.class);
        List<Pet> petsUnyamled = yamlSerializer.deserialize(petsYaml, Pet.class);
        System.out.println("Десериализованные объекты:");
        System.out.println(usersUnyamled);
        System.out.println(petsUnyamled);
    }

}
