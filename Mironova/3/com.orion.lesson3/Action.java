package com.orion.lesson3;

public class Action {

    public enum Type {
        GIFT, DISCOUNT
    };

    String name;
    Type type;
    int timeStart;
    int timeFinish;
    int value;

    public Action(String name, Type type, int value) {

        this.name = name;
        this.type = type;
        this.value = value;
    }
}
