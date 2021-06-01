package com.task7.Boxes;

public class Box<T> {
    private T content;

    public Box(T content) {
        if (content != null) { this.content = content; }
        else { throw new NullPointerException("Content of Box can't be null!"); }
    }

    public static <T> Box<T> of(T content) {
        return new Box<>(content);
    }

    public T get() {
        return content;
    }
}
