package com.orion.lesson5;

public class CheckedException {


    static class EmptyNameException extends Exception {
        public EmptyNameException() {
            super("Имя не может быть пустым ");
        }
    }

    static class Person {
        String name;

        public Person(String name) throws EmptyNameException {
            if (name == null || name.trim().isEmpty()) {
                throw new EmptyNameException();
            }
            this.name = name;
        }
    }


    public static void main(String[] args) {
        try {
            Person p = new Person("  ");
        } catch (EmptyNameException e) {
            e.printStackTrace();
        }
        System.out.println("Конец");
    }

}
