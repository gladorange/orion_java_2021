package com.lesson6.task1;

public enum AnimalsTypes {
    CAT("кошка"), DOG("собака"), MOUSE("мышь"), BEAR("медведь");
    final private String typeName;

    AnimalsTypes(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return typeName;
    }
}
