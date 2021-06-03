package com.lesson8.task2;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String,Operation> operations = new HashMap<>();

    public Double calculate(String operationName, Double number1, Double number2){
        if(operations.containsKey(operationName)) {
            return operations.get(operationName).operate(number1,number2);
        } else {
            throw new NullPointerException("operation not found");
        }
    }

    public void addOperation(String operationName, Operation operation){
        operations.put(operationName, operation);
    }
}
