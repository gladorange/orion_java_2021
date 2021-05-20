package com.lesson6;

import java.util.Objects;

public class Pair <T1,T2> {

    private static int ID = 0;
    private int id;
    private T1 field1;
    private T2 field2;


    public Pair( T1 var1, T2 var2 ) {
        field1 = var1;
        field2 = var2;
        this.id = ID++;
    }


    public T1 getFirst(){
        return field1;
    }

    public T2 getSecond(){
        return field2;
    }


    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Pair<?, ?> pair = ( Pair<?, ?> ) o;
        return id == pair.id &&
                Objects.equals( field1, pair.field1 ) &&
                Objects.equals( field2, pair.field2 );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
        result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
        return result;
    }
}
