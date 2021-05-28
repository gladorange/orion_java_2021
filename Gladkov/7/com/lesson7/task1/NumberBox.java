package com.lesson7.task1;

import com.lesson7.Box;

import java.util.Objects;

public class NumberBox<T extends Number> {
    private static Number value;


    private NumberBox( T value ){
        NumberBox.value = Objects.requireNonNull( value );
    }


    public static <T extends Number> NumberBox<T> of( T value ) {
        return new NumberBox<T>( value );
    }

    public static NumberBox add( Box<? extends Number> anotherBox ){
        return NumberBox.of((anotherBox.get()).longValue() + value.longValue());
    }

    public static  NumberBox multiply( Box<? extends Number> anotherBox ){
        return NumberBox.of((anotherBox.get()).longValue() * value.longValue());
    }

    public static Number get() {
        return value;
    }
}
