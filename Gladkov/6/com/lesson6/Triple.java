package com.lesson6;

import java.util.Objects;

public class Triple<T1,T2,T3> {
    private T1 field1;
    private T2 field2;
    private T3 field3;


    public Triple( T1 var1, T2 var2, T3 var3 ) {
        field1 = var1;
        field2 = var2;
        field3 = var3;
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
        return  Objects.equals( field1, triple.field1 ) &&
                Objects.equals( field2, triple.field2 ) &&
                Objects.equals( field3, triple.field3 );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
        result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
        result = prime * result + ((field3 == null) ? 0 : field3.hashCode());
        return result;
    }
}
