package com.orion.java.hw5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();

        Button addBtn = new Button(25, 65, 35, 10, "Добавить элемент", true, new AddElementOnClick(ui));
        TextField positionX = new TextField(20, 25, 15, 10, "Координата X для нового элемента", true, "10");
        TextField positionY = new TextField(60, 25, 15, 10, "Координата Y для нового элемента", true, "50");

        ui.addElement(addBtn);
        ui.addElement(positionX);
        ui.addElement(positionY);

        addBtn.click();

        for (int i = 0; i < 10; i++) {
            positionX.setText(String.valueOf(new Random().nextInt(UI.UI_WEIGHT)));
            positionY.setText(String.valueOf(new Random().nextInt(UI.UI_HEIGHT)));
            addBtn.click();
        }

        ui.displayAllElements();
    }
}
