package com.task6.Tuples;

import java.util.Objects;

public class Pair<T, U> {
    private final T FIRST;
    private final U SECOND;

    public Pair(T first, U second) {
        this.FIRST = first;
        this.SECOND = second;
    }

    public T getFirst() {
        return FIRST;
    }

    public U getSecond() {
        return SECOND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(FIRST, pair.FIRST) && Objects.equals(SECOND, pair.SECOND);
    }

    @Override
    public int hashCode() {
        // Вообще, поскольку я решил делать immutable кортежи, то переопределять не обязательно
        // return Objects.hash(FIRST, SECOND);

        // честно подсморел в хабре (https://habr.com/ru/post/168195/)
        final int prime = 31;
        int result = 1;
        result = prime * result + FIRST.hashCode();
        result = prime * result + SECOND.hashCode();
        return result;
    }
}
