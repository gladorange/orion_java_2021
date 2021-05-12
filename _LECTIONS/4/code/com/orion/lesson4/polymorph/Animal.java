package com.orion.lesson4.polymorph;

public abstract class Animal {

    String name;


    public Animal(String name) {
        this.name = name;
    }


    abstract void saySomething();

    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        void saySomething() {
            System.out.println("Гав");

        }


        void gavGav() {
            System.out.println("Гав-гав!!!!");
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        void saySomething() {
            System.out.println("мяу");
        }
    }


    public static void main(String[] args) {
       /* Animal dog = new Dog("Sharik");
        System.out.println(dog.name);
        dog.saySomething();


        Animal cat = new Cat("Barsik");
        cat.saySomething();


        Animal[] animals = {null};
        addCat(animals);
        animals[0].saySomething();

        */

        Animal someAnimal = new Dog("Sharik");
        System.out.println(someAnimal.name);
        someAnimal.saySomething();


        if (someAnimal instanceof Dog) {
            final Dog dog = (Dog) someAnimal;
            dog.gavGav();
        }

    }


    public static void addCat(Animal[] cats) {
        cats[0] = new Cat("Murka");
    }
}
