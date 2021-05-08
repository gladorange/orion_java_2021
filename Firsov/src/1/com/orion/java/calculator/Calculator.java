package com.orion.java.calculator;

/**
 * Класс калькулятор.
 */
public class Calculator {


    /**
     * Первое число типа Integer.
     */
    private Integer firstNumber_;
    /**
     * Второе число типа Integer.
     */
    private Integer secondNumber_;
    /**
     * Конструктор класса.
     * @param firstNumber  Первое число типа Integer.
     * @param secondNumber Второе число типа Integer.
     *
     * \n
     * Конструктор принимает два числа и присваивает их полям экземпляра класса.
     */
    public Calculator(Integer firstNumber, Integer secondNumber)
    {
        this.firstNumber_ = firstNumber;
        this.secondNumber_ = secondNumber;
    }

    /**
     * Метод возвращает первое число типа Integer firstNumber_.
     */
    public Integer firstNumber(){ return firstNumber_; }

    /**
     * Метод возвращает второе число типа Integer secondNumber_.
     */
    public Integer secondNumber(){
        return secondNumber_;
    }

    /**
     * Метод сравнивает два числа.
     * @return Возвращает 1,если первое число больше,чем второе число.
     * Возвращает -1,если первое число меньше,чем второе число.
     * Возвращает 0,если первое число равно второму числу.
     */
    public Integer compare(){
        if(this.firstNumber_ > this.secondNumber_ ){
            return 1;
        }else if ( this.firstNumber_ < this.secondNumber_ ){
            return -1;
        }else{
            return 0;
        }
    }

    /**
     * Метод возвращает сумму всех двух чисел.
     */
    public Integer sum(){
        return (this.firstNumber_+this.secondNumber_) ;
    }
}
