package com.orion.java.homework8.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String, Operation> operations = new HashMap<>();

    public Double calculate( String name, Double a, Double b ){
        return operations.get( name ).doOperation( a, b );
    }
    public void addOperation( String name, Operation implementation ){
        operations.put( name, implementation );
    }
}
