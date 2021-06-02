package home.work8.task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String,Operation> operations = new HashMap<>();

    public void calculate(String operationName, Double number1, Double number2){

        for (Map.Entry<String,Operation> el : operations.entrySet()){
            if (el.getKey().equals(operationName)){
                System.out.println(el.getValue().doOperation(number1,number2));
            }
        }
    }

    public void addOperation(String operationName, Operation implementation){
        operations.put(operationName,implementation);
    }
}
