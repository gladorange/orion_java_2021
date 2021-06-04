package com.orion.java.homework7;

/**
 * Класс предназначен для хранения значение типа T.
 * @param <T>
 *
 * \n
 * Класс Immutable и null-safe.
 */
public class Box<T> {

    /**
     * Значение,хранящееся в классе Box.
     * Может быть как Immutable, так и не Immutable.
     */
    protected T value;


    protected Box( T value ){
       if(value == null){
           throw new IllegalArgumentException("Error:Value can't be null");
       }
       this.value = value;
    }

    public Box( ) {
    }

    public static <T> Box<T> of(T value ) {
        return new Box<>( value );
    }

    public T getValue() {
        return value;
    }
}


