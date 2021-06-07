package com.lesson8.task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String,Operation> operationMap = new HashMap<>();

    public Double calculate( String operationName, Double number1, Double number2 ){
        return operationMap.get( operationName ).doOperation( number1, number2 );
    }

    public void addOperation( String operationName, Operation implementation ){
        operationMap.put( operationName, implementation );
    }
}
