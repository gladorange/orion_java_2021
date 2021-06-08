package com.task8;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void run() {
        Calculator calculator = new Calculator();
        calculator.addOperation("add", (Double::sum));
        calculator.addOperation("sub", ((arg1, arg2) -> arg1 - arg2));
        calculator.addOperation("mul", ((arg1, arg2) -> arg1 * arg2));
        calculator.addOperation("div", ((arg1, arg2) -> arg1 / arg2));
        calculator.addOperation("pow", (Math::pow));
        calculator.addOperation("nrt", ((arg1, arg2) -> Math.pow(arg1, 1./arg2)));

        double arg1 = 16, arg2 = 4;
        calculator.getSupportedOperations()
                .forEach( (nameOp, op) -> System.out.printf("Проверка операции %s(%f, %f): %f%n", nameOp, arg1, arg2,
                                                       calculator.calculate(nameOp, arg1, arg2)));
        /*
        // - uncomment to check "UnsupportedOperationException" behavior
        System.out.printf("Проверка операции nop(%f, %f): %f%n", arg1, arg2, calculator.calculate("nop", arg1, arg2));
        */
    }

    public interface Operation {
        double doOperation(double arg1, double arg2) throws ArithmeticException;
    }

    public static class Calculator {
        private Map<String, Operation> supportedOperations = new HashMap<>();

        private static class UnsupportedOperationException extends NullPointerException {
            public UnsupportedOperationException(String s) {
                super(s);
            }
        }

        public void addOperation(String operationName, Operation implementation) {
            supportedOperations.put(operationName, implementation);
        }

        public double calculate(String operationName, double arg1, double arg2) {
            if (!supportedOperations.containsKey(operationName)) {
                throw new UnsupportedOperationException("Operation named \"" + operationName + "\" is not supported by " + this);
            }
            return supportedOperations.get(operationName).doOperation(arg1, arg2);
        }

        public Map<String, Operation> getSupportedOperations() {
            return supportedOperations;
        }
    }
}
