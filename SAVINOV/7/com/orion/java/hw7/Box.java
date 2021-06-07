package com.orion.java.hw7;

public class Box<T> {
    private T box;

    public Box() {
    }

    private Box(T box) {
        if (box == null) {
            throw new NullPointerException("Box can't be Null");
        }
        this.box = box;
    }

    public static <T> Box<T> of(T box) {
        return new Box<T>(box);
    }

    public T get() {
        return box;
    }
}


