package com.orion.lesson4.inner;

public class ImmutableAnimal {

    private String name;
    private int weight;


    public ImmutableAnimal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }


    public ImmutableAnimal withName(String name) {
        return new ImmutableAnimal(name, this.weight);
    }


    public static void main(String[] args) {
        final ImmutableAnimal barsik = new ImmutableAnimal("Barsik", 2);
        System.out.println(barsik.getWeight());
        System.out.println(barsik.getName());

        final ImmutableAnimal барсик = barsik.withName("Барсик");
        System.out.println(барсик.getWeight());
        System.out.println(барсик.getName());

    }
}
