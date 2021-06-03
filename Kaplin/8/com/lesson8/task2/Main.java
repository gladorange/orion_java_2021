package com.lesson8.task2;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addOperation("multi", (a,b) -> a*b);
        calc.addOperation("div", (a,b) -> a/b);
        calc.addOperation("add", Double::sum);
        calc.addOperation("sub", (a,b) -> a-b);
        calc.addOperation("pow", Math::pow);
        calc.addOperation("exp", (a,b) -> Math.exp(Math.log(a)/b));
        System.out.println(calc.calculate("multi",2.,3.));
        System.out.println(calc.calculate("div",6.,3.));
        System.out.println(calc.calculate("add",2.,3.));
        System.out.println(calc.calculate("sub",6.,3.));
        System.out.println(calc.calculate("pow",2.,3.));
        System.out.println(calc.calculate("exp",2.,3.));
    }

}
