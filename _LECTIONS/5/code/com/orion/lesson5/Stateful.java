package com.orion.lesson5;

public interface Stateful {

    default boolean isTurnedOn() {
        return false;
    }
}
