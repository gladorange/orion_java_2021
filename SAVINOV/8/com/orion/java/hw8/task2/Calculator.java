package com.orion.java.hw8.task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Map<String, Operation> operationList;

    public Calculator() {
        operationList = new HashMap<>();
    }

    public void calculate(String operationName, Double number1, Double number2) {
        if (operationList.containsKey(operationName)) {
            System.out.printf("%.2f %8s %.2f = %.2f\n", number1, operationName, number2, operationList.get(operationName).doOperation(number1, number2));
        } else {
            System.out.printf("Sorry, this key '%s' is not available\n", operationName);
        }
    }

    public void addOperation(String operationName, Operation implementation) {
        operationList.put(operationName, implementation);
    }

    public Map<String, Operation> getOperationList() {
        return operationList;
    }
}
