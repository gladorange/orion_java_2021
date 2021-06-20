package com.orion.java.hw10;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Animal animal = new Animal("Pushok", "Cat");
        Person person = new Person("Ivan", "Ivanov", "Man");
        Telephone telephone = new Telephone("landline", "+7831123456");

        String xmlString = Methods.serialize(animal, person, telephone);
        System.out.println(xmlString);

        Animal returnedAnimal = Methods.deserialize(xmlString, Animal.class);
        Person returnedPerson = Methods.deserialize(xmlString, Person.class);
        Telephone returnedTelephone = Methods.deserialize(xmlString, Telephone.class);

        System.out.println(returnedAnimal);
        System.out.println(returnedPerson);
        System.out.println(returnedTelephone);
    }
}
