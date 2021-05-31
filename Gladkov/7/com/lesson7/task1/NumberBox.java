package com.lesson7.task1;

import com.lesson7.Box;

import java.util.Objects;

public class NumberBox<T extends Number> extends Box {
    private Number value;


    private NumberBox( T value ){
        this.value = Objects.requireNonNull( value );
    }


    public static <T extends Number> NumberBox<T> of( T value ) {
        return new NumberBox<T>( value );
    }

    public NumberBox add( Box<? extends Number> anotherBox ){
        return NumberBox.of((anotherBox.get()).longValue() + value.longValue());
    }

    public NumberBox multiply( Box<? extends Number> anotherBox ){
        return NumberBox.of((anotherBox.get()).longValue() * value.longValue());
    }

    public Number get() {
        return value;
    }
}
