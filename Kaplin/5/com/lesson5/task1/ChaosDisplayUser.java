package com.lesson5.task1;

import com.lesson5.task1.abstractions.Clickable;
import com.lesson5.task1.abstractions.Element;
import com.lesson5.task1.elements.Button;
import com.lesson5.task1.elements.CheckBox;
import com.lesson5.task1.elements.TextField;
import com.lesson5.task1.exceptions.ReadOnlyException;

import java.util.Random;

public class ChaosDisplayUser {
    private UI display;

    public ChaosDisplayUser(UI display) {
        this.display = display;
    }

    public void createChaosElements(Button addRandomElementButton, TextField xField, TextField yField, int clickCount) {
        for (int i = 0; i < clickCount; i++) {
            xField.setText(String.valueOf(new Random().nextInt(display.getXMax())));
            yField.setText(String.valueOf(new Random().nextInt(display.getYMax())));
            try {
                addRandomElementButton.click();
            } catch (ReadOnlyException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkDisplay() {
        for (Element elem : display.getAllElements()) {
            System.out.println(elem.toString());
            if (elem instanceof Button || elem instanceof CheckBox) {
                try {
                    ((Clickable) elem).click();
                } catch (ReadOnlyException e) {
                    e.printStackTrace();
                }
                if (elem instanceof CheckBox) {
                    System.out.println("Состояние чекбокса после клика: " + ((CheckBox) elem).checked());
                }
            } else {
                TextField textField = (TextField) elem;
                System.out.println("Текстовое поле содержит: " + textField.getText());
            }
        }
    }
}
