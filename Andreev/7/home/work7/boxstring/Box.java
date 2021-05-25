package home.work7.boxstring;

public class Box<T extends CharSequence> {
    private final T value;

    public Box(T value) {
        if (value!=null) {
            this.value = value;
        }else {
            throw new NullPointerException("Value is not to be null");
        }
    }

    public T getValue(){
        return value;
    }

}
