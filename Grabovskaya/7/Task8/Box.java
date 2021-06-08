package Task8;

public class Box <T>
{
    private T element;

    public Box(T element)
    {
        if (element == null)
        {
            throw new NullPointerException("Element can't be null");
        }
        this.element = element;
    }

    public T getElement() { return element; }
}
