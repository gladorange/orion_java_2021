package com.orion.java.homework6.elementtypes;

import java.util.Objects;

public class Triple <T,U,V> {
    private T first;
    private U second;
    private V third;


    public Triple( T var1, U var2, V var3 ) {
        if( var1 == null || var2 == null || var3 == null){
            throw new NullPointerException("Error:Arguments in constructor can't be null.");
        }
        first = var1;
        second = var2;
        third = var3;
    }


    public T getFirst(){
        return first;
    }

    public U getSecond(){
        return second;
    }

    public V getThird (){
        return third;
    }


    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Triple<?, ?, ?> triple = ( Triple<?, ?, ?> ) o;
        return  Objects.equals( first, triple.first ) &&
                Objects.equals( second, triple.second ) &&
                Objects.equals( third, triple.third );
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
        result = prime * result + ((third == null) ? 0 : third.hashCode());
        return result;
    }
}
