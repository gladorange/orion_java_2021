package com.orion.lesson4;

public class Animal {

    String name;
    String type;
    int weight;


    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, String type, int weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public Animal() {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
