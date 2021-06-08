package com.orion.java.hw7;

public class NumberBox<T extends Number> extends Box {
    private T number;

    private NumberBox(T number) {
        if (number == null) {
            throw new NullPointerException("NumberBox can't be Null");
        }
        this.number = number;
    }

    public static <T extends Number> NumberBox<T> of(T number) {
        return new NumberBox<T>(number);
    }

    public NumberBox add(Box<? extends Number> anotherBox) {
        return NumberBox.of((anotherBox.get()).doubleValue() + number.doubleValue());
    }

    public NumberBox multiply(Box<? extends Number> anotherBox) {
        return NumberBox.of((anotherBox.get()).doubleValue() * number.doubleValue());
    }

    public T get() {
        return number;
    }
}
