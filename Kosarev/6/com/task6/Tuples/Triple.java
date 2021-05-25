package com.task6.Tuples;

import java.util.Objects;

public class Triple<T, U, V> extends Pair<T, U>{
    private final V THIRD;

    public Triple(T first, U second, V third) {
        super(first, second);
        this.THIRD = third;
    }

    public V getThird() {
        return THIRD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(THIRD, triple.THIRD);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime * super.hashCode() + THIRD.hashCode();
    }
}
