package com.orion.java.homework6.elementtypes;

import java.util.Objects;

public class Pair <T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        if(first == null || second ==null ){
            throw new NullPointerException("Error:Arguments in constructor can't be null.");
        }
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(this.first, ((Pair<?, ?>) obj).first) && Objects.equals(this.second, ((Pair<?, ?>) obj).second);
    }

    @Override
    /**
     * Пример взят из интернета,рассмотрены были 2 сайта, и везде почему то выбрали result=31.
     */
    public int hashCode() {

        final int prime = 7;
        int result = 1;
        result = prime * result + first.hashCode();
        result = prime * result + second.hashCode();
        return result;
    }
}
