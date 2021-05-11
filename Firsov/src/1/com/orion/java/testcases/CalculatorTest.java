package com.orion.java.testcases;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import com.orion.java.calculator.Calculator;

/**
 * Класс,представляющий собой тестовые данные для проверки методов класса Calculator.
 */
class TestCase{
    /**
     * Конструктор класса.
     *
     * @param firstNumber Первое число.
     * @param secondNumber Второе число.
     * @param compareResult Результат сравнение первого и второго числа.
     * @param sumResult Сумма первого и второго числа.
     */
    TestCase(Integer firstNumber, Integer secondNumber,Integer compareResult,Integer sumResult)
    {
        this.firstNumber_ = firstNumber;
        this.secondNumber_ = secondNumber;
        this.compareResult_ = compareResult;
        this.sumResult_ = sumResult;
    }

    /**
     * Метод возвращает первое число firstNumber_.
     */
    Integer firstNumber (){ return firstNumber_; }
    /**
     * Метод возвращает второе число secondNumber_.
     */
    Integer secondNumber (){ return secondNumber_; }

    /**
     * Метод возвращает результат сравнение первого и второго числа.
     */
    Integer compareResult (){ return compareResult_; }
    /**
     * Метод возвращает сумму первого и второго числа.
     */
    Integer sumResult (){ return sumResult_; }

    /**
     * Первое число типа Integer.
     */
    private Integer firstNumber_;
    /**
     * Второе число типа Integer.
     */
    private Integer secondNumber_;
    /**
     * Результат сравнение первого и второго числа типа Integer.
     */
    private Integer compareResult_;
    /**
     * Сумма первого и второго числа.
     */
    private Integer sumResult_;
}

/**
 *  Класс,содержащий метод для тестирование методов класса Calculator.
 */
public class CalculatorTest {
    @Test
    /**
     * Метод для тестирования методов класса Calculator.
     */
    public void testCalc()  throws Exception{
        List<TestCase> testCases = new ArrayList<>();
        testCases.add(new TestCase(1,3,-1,4));
        testCases.add(new TestCase(3,1,1,4));
        testCases.add(new TestCase(-1,3,-1,2));
        testCases.add(new TestCase(3,-1,1,2));
        testCases.add(new TestCase(-3,1,-1,-2));
        testCases.add(new TestCase(1,-3,1,-2));
        testCases.add(new TestCase(Integer.MAX_VALUE,Integer.MAX_VALUE,0,-2));
        testCases.add(new TestCase(Integer.MIN_VALUE,Integer.MIN_VALUE,0,0));
        testCases.add(new TestCase(Integer.MAX_VALUE,1,1,Integer.MIN_VALUE));
        testCases.add(new TestCase(Integer.MIN_VALUE,-1,-1,Integer.MAX_VALUE));

        for(int i = 0; i<testCases.size();i++){
            Calculator calculator  = new Calculator(testCases.get(i).firstNumber(),testCases.get(i).secondNumber());
            int result = calculator.compare();
            int reaulResult = testCases.get(i).compareResult();
            Assert.assertEquals(result,reaulResult);
            result = calculator.sum();
            reaulResult = testCases.get(i).sumResult();
            Assert.assertEquals(result,reaulResult);
        }
    }
}
