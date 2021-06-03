package com.lesson7.task1;

public class NumberBox extends Box<Number> {
    public NumberBox(Number value) {
        super(value);
    }

    static NumberBox of(Number i) {
        return new NumberBox(i);
    }

    public NumberBox add(Box<? extends Number> box) {
        Number adding = box.getValue();
        Number result;
        if(this.getValue() instanceof Double || adding instanceof Double) {
            result = this.getValue().doubleValue() + adding.doubleValue();
        } else if(this.getValue() instanceof Float || adding instanceof Float) {
            result = this.getValue().floatValue() + adding.floatValue();
        } else if(this.getValue() instanceof Long || adding instanceof Long) {
            result = this.getValue().longValue() + adding.longValue();
        } else {
            result = this.getValue().intValue() + adding.intValue();
        }
        return new NumberBox(result);
    }

    public NumberBox multiply(Box<? extends Number> box) {
        Number adding = box.getValue();
        Number result;
        if(this.getValue() instanceof Double || adding instanceof Double) {
            result = this.getValue().doubleValue() * adding.doubleValue();
        } else if(this.getValue() instanceof Float || adding instanceof Float) {
            result = this.getValue().floatValue() * adding.floatValue();
        } else if(this.getValue() instanceof Long || adding instanceof Long) {
            result = this.getValue().longValue() * adding.longValue();
        } else {
            result = this.getValue().intValue() * adding.intValue();
        }
        return new NumberBox(result);
    }
}
