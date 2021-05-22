package com.lesson6.task1;

public enum AnimalType {
    DOG( "Собака", "Косточка" ),
    CAT( "Кошка", "Сметана" ),
    SNAKE ( "Змея", "Мышка" ),
    MOUSE ( "Мышь", "Сыр" );

    private String type;
    private String favoriteFood;

    AnimalType( String type, String favoriteFood ){
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
