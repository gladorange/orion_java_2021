package Task7;

import java.util.Objects;

public class Triple <T1, T2, T3> extends Pair <T1, T2>
{
    private T3 third;

    public Triple(T1 first, T2 second, T3 third)
    {
        super(first, second);
        this.third = third;
    }

    public T3 getThird() { return third; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), third);
    }
}
