package com.lesson6.utils;

public class Pair<T1, T2> {
    private T1 field1;
    private T2 field2;

    public Pair(T1 field1, T2 field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public T1 getFirst() {
        return field1;
    }

    public T2 getSecond() {
        return field2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (field1 == null ? 0 : field1.hashCode());
        result = prime * result + (field2 == null ? 0 : field2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair<?, ?> other = (Pair<?, ?>) obj;
        if (!field1.equals(other.field1))
            return false;
        if (!field2.equals(other.field2))
            return false;
        return true;
    }

}
