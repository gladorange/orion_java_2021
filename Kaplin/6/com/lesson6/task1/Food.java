package com.lesson6.task1;

public enum Food {
    MEAT("мясо"), CHEES("сыр"), HONEY("мёд"), MILK("молоко");
    final private String foodName;

    Food(String typeName) {
        this.foodName = typeName;
    }

    @Override
    public String toString() {
        return foodName;
    }
}
