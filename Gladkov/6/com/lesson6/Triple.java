package com.lesson6;

import java.util.Objects;

public class Triple<T1,T2,T3> {
    private static long ID = 0;
    private long id;
    private T1 field1;
    private T2 field2;
    private T3 field3;


    public Triple( T1 var1, T2 var2, T3 var3 ) {
        field1 = var1;
        field2 = var2;
        field3 = var3;
        this.id = ( ID += 1L );
    }


    public T1 getFirst(){
        return field1;
    }

    public T2 getSecond(){
        return field2;
    }

    public T3 getThird (){
        return field3;
    }


    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Triple<?, ?, ?> triple = ( Triple<?, ?, ?> ) o;
        return id == triple.id &&
                Objects.equals( field1, triple.field1 ) &&
                Objects.equals( field2, triple.field2 ) &&
                Objects.equals( field3, triple.field3 );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
