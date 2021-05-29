package com.lesson7.task1;

public class Box<T> {
    private final T value;

    static <T> Box<T> of(T i) {
        return new Box<T>(i);
    }

    public Box(T value) throws NullPointerException {
        if(value == null) {
            throw new NullPointerException("Content can't be null");
        }
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
