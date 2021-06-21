package com.orion.java.homework6.animals;

public enum  AnimalTypesClass {
    CAT( "Кошка", "Рыба" ),
    DOG( "Собака", "Мясо" ),
    MOUSE ( "Мышь", "Сыр" );

    private String type;
    private String favoriteFood;

    AnimalTypesClass( String type, String favoriteFood ){
        this.type = type;
        this.favoriteFood = favoriteFood;
    }

    public String getType() {
        return type;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }
}
