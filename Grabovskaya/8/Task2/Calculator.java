package Task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator
{
    private Map<String, Operation> operations = new HashMap<>();

    Double calculate(String operationName, Double number1, Double number2)
    {
        if (!operations.containsKey(operationName))
        {
            System.out.println("Операция " + operationName + " не определена!");
            return 0.0;
        }
        return operations.get(operationName).doOperation(number1, number2);
    }

    void addOperation(String operationName, Operation implementation)
    {
        operations.put(operationName, implementation);
    }

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
        calc.addOperation("+", (a,b) -> a+b);
        calc.addOperation("-", (a,b) -> a-b);
        calc.addOperation("*", (a,b) -> a*b);
        calc.addOperation("/", (a,b) -> a/b);
        calc.addOperation("pow", (a,b) -> Math.pow(a, b));
        calc.addOperation("nrt", (a,b) -> Math.pow(a, (1/b)));

        System.out.println(calc.calculate("+",2.0,3.0));
        System.out.println(calc.calculate("-",2.0,3.0));
        System.out.println(calc.calculate("*",2.0,3.0));
        System.out.println(calc.calculate("/",6.0,3.0));
        System.out.println(calc.calculate("pow",2.0,3.0));
        System.out.println(calc.calculate("nrt",16.0,2.0));
    }
}
