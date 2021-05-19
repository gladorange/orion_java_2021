package com.orion.lesson6;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsVsHashCode {



    static class Animal {
        String name;
        String type = "Dog";

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Animal animal = (Animal) o;
            return
                    Objects.equals(name, animal.name) &&
                    Objects.equals(type, animal.type)
                    ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
           // return 42;
        }


        public static void main(String[] args) {
            Set<Animal> animals = new HashSet<>();
            final Animal sharik = new Animal("шарик");
            animals.add(sharik);


            System.out.println(animals);
            sharik.name = "Шарик";
            System.out.println(animals.contains(sharik));

            animals.add(sharik);

            System.out.println(animals);


            for (Animal animal : animals) {
                if (animal == sharik) {
                    System.out.println("Шарик нашелся!");
                }
            }
        }
    }

}
