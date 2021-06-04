package home.work8.task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String,Operation> operations = new HashMap<>();

    public void calculate(String operationName, Double number1, Double number2){

        Operation operation = operations.get(operationName);

        if (operation!=null){
            operations.get(operationName).doOperation(number1,number2);
        }else{
            throw new IllegalArgumentException("Операции " + operationName + " не существует!");
        }
    }

    public void addOperation(String operationName, Operation implementation){
        operations.put(operationName,implementation);
    }
}
