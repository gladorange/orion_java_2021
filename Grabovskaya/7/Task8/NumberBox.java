package Task8;

public class NumberBox <T extends Number> extends Box <T>
{
    public NumberBox(T element)
    {
        super(element);
    }

    public NumberBox<Number> add(Box<? extends Number> anotherBox)
    {
        double sum = getElement().doubleValue() + anotherBox.getElement().doubleValue();
        return new NumberBox<>(sum);
    }

    public NumberBox<Number> multiply(Box<? extends Number> anotherBox)
    {
        double product = getElement().doubleValue() * anotherBox.getElement().doubleValue();
        return new NumberBox<>(product);
    }
}
