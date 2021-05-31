package com.lesson7;

import java.util.Objects;

public class Box<T> {
    private T value;


   private Box( T value ){
       this.value = Objects.requireNonNull( value );
    }

    public Box( ) {
    }

    public static <T> Box<T> of(T value ) {
        return new Box<>( value );
    }

    public T get() {
        return value;
    }
}
