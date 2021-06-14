package com.orion.java.hw8.task2;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addOperation("plus", (a, b) -> a + b);
        calc.addOperation("division", (a, b) -> a / b);
        calc.addOperation("multiply", (a, b) -> a * b);
        calc.addOperation("minus", (a, b) -> a - b);
        calc.addOperation("pow", (a, b) -> Math.pow(a, b));
        calc.addOperation("sqrt", (a, b) -> Math.pow(a, 1. / b));

        calc.calculate("sum", 2., 3.);
        calc.calculate("plus", 2., 3.);
        calc.calculate("division", 2., 3.);
        calc.calculate("multiply", 2., 3.);
        calc.calculate("minus", 2., 3.);
        calc.calculate("pow", 2., 3.);
        calc.calculate("sqrt", 2., 3.);
    }
}
