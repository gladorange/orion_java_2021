package com.orion.java.homework7;

public class NumberBox<T extends Number> extends Box<T> {

    private NumberBox( T value ){
        super(value);
    }

    public static <T extends Number> NumberBox<T> of( T value ) {
        return new NumberBox<>( value );
    }
    public NumberBox<?> add(Box<? extends Number> argBox ) {
        if(getValue() instanceof Double || argBox .getValue() instanceof Double
        || getValue() instanceof Float || argBox .getValue() instanceof Float){
            return NumberBox.of( (getValue().doubleValue() + argBox.getValue().doubleValue()) );
        }else {
            return NumberBox.of( (getValue().longValue() + argBox.getValue().longValue()) );
        }
    }
    public NumberBox<?> multiply(Box<? extends Number> argBox) {
        if(getValue() instanceof Double || argBox .getValue() instanceof Double
                || getValue() instanceof Float || argBox .getValue() instanceof Float){
            return NumberBox.of( (getValue().doubleValue() * argBox.getValue().doubleValue()) );
        }else {
            return NumberBox.of( (getValue().longValue() * argBox.getValue().longValue()) );
        }
    }

}
