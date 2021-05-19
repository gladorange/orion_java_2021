package home.work6.task.pairs;

import java.util.Objects;
import java.util.Random;

public class Triple <T1,T2 extends Comparable<T2>,T3> implements Comparable<Triple<T1,T2,T3>>{

    private int id;
    private T1 firstParametr;
    private T2 secondParametr;
    private T3 thirdParametr;

    public Triple(T1 name, T2 info, T3 additionalInfo) {
        this.firstParametr = name;
        this.secondParametr = info;
        this.thirdParametr = additionalInfo;
        this.id = new Random().nextInt();
    }

    public T1 getFirst(){
        return firstParametr;
    }

    public T2 getSecond(){
        return secondParametr;
    }

    public T3 getThird(){
        return thirdParametr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return id == triple.id && Objects.equals(firstParametr, triple.firstParametr) && Objects.equals(secondParametr, triple.secondParametr) && Objects.equals(thirdParametr, triple.thirdParametr);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstParametr == null) ? 0 : firstParametr.hashCode());
        result = prime * result + ((secondParametr == null) ? 0 : secondParametr.hashCode());
        result = prime * result + ((thirdParametr == null) ? 0 : thirdParametr.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "firstParametr=" + firstParametr +
                ", secondParametr=" + secondParametr +
                ", thirdParametr=" + thirdParametr +
                '}';
    }

    @Override
    public int compareTo(Triple<T1, T2, T3> o) {
        return getSecond().compareTo(o.getSecond());
    }
}
