package home.work6.task.pairs;

import java.util.Objects;
import java.util.Random;

public class Pair<T1,T2> {

    private int id;
    private T1 firstParametr;
    private T2 secondParametr;

    public Pair(T1 parametr1, T2 parametr2) {
        this.firstParametr = parametr1;
        this.secondParametr = parametr2;
        this.id = new Random().nextInt();
    }

    public T1 geFirst() {
        return firstParametr;
    }

    public T2 getSecond() {
        return secondParametr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(firstParametr, pair.firstParametr) && Objects.equals(secondParametr, pair.secondParametr);
    }

    @Override
    public int hashCode() {
        final int prime = 24;
        int result = 1;
        result = prime * result + ((firstParametr == null) ? 0 : firstParametr.hashCode());
        result = prime * result + ((secondParametr == null) ? 0 : secondParametr.hashCode());
        return result;
    }

}
