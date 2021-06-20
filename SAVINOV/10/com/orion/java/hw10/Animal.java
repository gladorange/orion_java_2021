package com.orion.java.hw10;

@MyAnnotation.XmlTypeName("Animal")
public class Animal {
    @MyAnnotation.XmlName("Name")
    String name;
    @MyAnnotation.XmlName("Type")
    String typeAnimal;

    public Animal() {
    }

    public Animal(String name, String typeAnimal) {
        this.name = name;
        this.typeAnimal = typeAnimal;
    }

    public String getName() {
        return name;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", typeAnimal='" + typeAnimal + '\'' +
                '}';
    }
}
