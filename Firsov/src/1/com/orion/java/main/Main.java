package com.orion.java.main;

import com.orion.java.paramgetter.ParametersGetter;
import com.orion.java.paramgetter.ConsoleParametersGetter;
import com.orion.java.paramgetter.CommandLineParametersGetter;
import com.orion.java.calculator.Calculator;
/**
 * Класс,содержащий точку входа в приложение.
 */
public class Main {
    /**
     * Точка входа в приложение.
     * @param args Аргументы переданные через командную строку.
     */
    public static void main(String[] args) {
        ParametersGetter parametersGetter;
        if(args.length == 0){
            parametersGetter = new ConsoleParametersGetter();
        }else{
            parametersGetter = new CommandLineParametersGetter();
        }
        Integer[] integerValues = {-1,-1};
        parametersGetter.getParameters(integerValues,args);
        Calculator calculator=new Calculator(integerValues[0],integerValues[1]);
        switch (calculator.compare()){
            case 1:
                System.out.println("Число "+ calculator.secondNumber() +" меньше "+ calculator.firstNumber());
                break;
            case -1:
                System.out.println("Число "+ calculator.firstNumber() +" меньше "+ calculator.secondNumber());
                break;
            case 0:
                System.out.println("Число "+ calculator.firstNumber() +" равно "+ calculator.secondNumber());
                break;
            default:
                break;
        }
        System.out.println("Сумма двух чисел "+calculator.sum());
    }
}
