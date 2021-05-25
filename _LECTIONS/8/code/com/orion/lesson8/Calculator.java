package com.orion.lesson8;

public class Calculator {


    static Integer add(Integer one, Integer another) {
        return one + another;
    }

    static Integer subtract(Integer one, Integer another) {
        return one - another;
    }

    interface MathOperation {
        Integer operate(Integer a, Integer b);
    }


    public static void main(String[] args) {
        MathOperation plus = Calculator::add;
        MathOperation minus = Calculator::subtract;


        String[] operations = {"1+2", "5-1"};


        for (String operation : operations) {

            Integer arg1 = Integer.valueOf(String.valueOf(operation.charAt(0)));
            Integer arg2 = Integer.valueOf(String.valueOf(operation.charAt(2)));

            switch (String.valueOf(operation.charAt(1))) {
                case "+" -> System.out.println(plus.operate(arg1, arg2));
                case "-" -> System.out.println(minus.operate(arg1, arg2));
            }
        }


    }
}
