package com.orion.java.homework8.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testCalculatorOperation(){
        Calculator calc = new Calculator();
        calc.addOperation("mul", (a, b) -> a * b);
        assertEquals((double) calc.calculate("mul",2d,3d),6d,0);
        calc.addOperation("dev", (a, b) -> a / b);
        assertEquals((double) calc.calculate("dev",6d,3d),2d,0);
        calc.addOperation("sum", Double::sum);
        assertEquals((double) calc.calculate("sum",2d,3d),5d,0);
        calc.addOperation("sub", (a, b) -> a - b);
        assertEquals((double) calc.calculate("sub",5d,3d),2d,0);
        calc.addOperation("pow", Math::pow);
        assertEquals((double) calc.calculate("pow",2d,3d),8d,0);
        calc.addOperation("ext", (a, b) -> Math.pow(a, 1 / b));
        assertEquals((double) calc.calculate("ext",9d,2d),3d,0);
    }
}
