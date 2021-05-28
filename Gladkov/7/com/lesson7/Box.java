package com.lesson7;

import java.util.Objects;

public class Box<T> {
    private final T value;


   private Box( T value ){
       this.value = Objects.requireNonNull( value );
    }


    public static <T> Box<T> of( T value ) {
        return new Box<>( value );
    }

    public T get() {
        return value;
    }
}
