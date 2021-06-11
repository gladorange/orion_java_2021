package com.orion.lesson6.task.taskA;

public class Animal {

    private String name;
    private String type;

    public static enum AnimalType {
        DOG("Собака"),
        CAT("Кошка"),
        HORSE("Лошадь"),
        RABBIT("Кролик");

        private final String name;

        AnimalType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
