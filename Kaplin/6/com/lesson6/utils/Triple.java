package com.lesson6.utils;

public class Triple<T1, T2, T3> {
    private T1 field1;
    private T2 field2;
    private T3 field3;

    public Triple(T1 field1, T2 field2, T3 field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public T1 getFirst() {
        return field1;
    }

    public T2 getSecond() {
        return field2;
    }

    public T3 getThird() {
        return field3;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (field1 == null ? 0 : field1.hashCode());
        result = prime * result + (field2 == null ? 0 : field2.hashCode());
        result = prime * result + (field3 == null ? 0 : field3.hashCode());
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
        Triple<?, ?, ?> other = (Triple<?, ?, ?>) obj;
        if (!field1.equals(other.field1))
            return false;
        if (!field2.equals(other.field2))
            return false;
        if (!field3.equals(other.field3))
            return false;
        return true;
    }
}
