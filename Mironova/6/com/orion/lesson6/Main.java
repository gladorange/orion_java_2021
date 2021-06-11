package com.orion.lesson6;

import com.orion.lesson6.task.Task;
import com.orion.lesson6.task.TaskA;
import com.orion.lesson6.task.TaskB;
import com.orion.lesson6.task.TaskC;

public class Main {

    public static void main(String[] args) {

        System.out.println("Выполняем задания!");

        prepareSteps(new TaskA());
        prepareSteps(new TaskB());
        prepareSteps(new TaskC());
    }

    public static void prepareSteps(Task task){

        System.out.println("~~~~~~~~~~~~~~~~~//~~~~~~~~~~~~~~~~~");

        System.out.println("Генерируем среду для " + task.getClass().getSimpleName());
        task.initData();

        System.out.println("\nВыводим исходные данные:");
        task.printData();

        System.out.println("\nВыполняем задание:");
        task.actionTask();
    }

}

