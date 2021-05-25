package com.lesson5.task1;


import com.lesson5.task1.elements.Button;

import com.lesson5.task1.elements.TextField;

public class Main {
    public static void main(String[] args) {
        System.out.println("Before ChaosUser was coming");
        UI display = new UI(100, 100);
        TextField xField = new TextField("Координата x", 10, 5, 5, 3);
        TextField yField = new TextField("Координата y", 20, 5, 5, 3);
        Button addRandomElementButton = new Button("Добавить элемент", 30, 5, 5, 3, new AddRandomElement(display, xField, yField));
        display.addElement(addRandomElementButton);
        display.addElement(xField);
        display.addElement(yField);
        System.out.println("ChaosUser is coming and create elements");
        ChaosDisplayUser user = new ChaosDisplayUser(display);
        user.createChaosElements(addRandomElementButton, xField, yField, 10);
        // turnOff generation button
        addRandomElementButton.disableElement();
        System.out.println("ChaosUser checks display");
        user.checkDisplay();
    }
}
