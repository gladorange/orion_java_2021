package com.lesson5.task1;

import com.lesson5.task1.abstractions.ButtonClickCallback;
import com.lesson5.task1.abstractions.Element;
import com.lesson5.task1.abstractions.ElementType;
import com.lesson5.task1.elements.Button;
import com.lesson5.task1.elements.CheckBox;
import com.lesson5.task1.elements.TextField;

import java.util.Random;

public class AddRandomElement implements ButtonClickCallback {
    private final UI display;
    private final TextField xField;
    private final TextField yField;

    public AddRandomElement(UI display, TextField xField, TextField yField ) {
        this.xField = xField;
        this.yField = yField;
        this.display = display;
    }


    @Override
    public void onButtonClick() {
        int xCoord = Integer.parseInt(xField.getText());
        int yCoord = Integer.parseInt(yField.getText());
        Element elementToAdd = getRandomElement( xCoord, yCoord );
        display.addElement( elementToAdd );
    }

    private int generateRandomNumber(){
        return new Random().nextInt( 15) + 5;
    }

    private Element getRandomElement( int xCoord, int yCoord ) {
        ElementType elementType = ElementType.values()[new Random().nextInt( 3 )];
        int width = generateRandomNumber();
        int height = generateRandomNumber();
            switch ( elementType ) {
                case BUTTON:
                    String captionButton = String.format("Кнопка в (%s, %s)", xCoord , yCoord);
                    System.out.format("Создан элемент с координатами: (%s, %s)\n", xCoord , yCoord);
                    return new Button( captionButton, xCoord, yCoord, width, height, () ->
                            System.out.format("Нажата кнопка в (%s, %s) с названием: %s\n", xCoord, yCoord, captionButton));
                case CHECK_BOX:
                    String captionCheckBox = String.format("Чекбокс в (%s, %s)", xCoord , yCoord);
                    System.out.format("Создан элемент с координатами: (%s, %s)\n", xCoord , yCoord);
                    return new CheckBox( captionCheckBox, xCoord, yCoord, width, height, () ->
                            System.out.format("Нажат чекбокс в (%s, %s) с названием: %s \n", xCoord, yCoord, captionCheckBox));
                case TEXT_FIELD:
                    String captionTextField = String.format("Текстовое поле в (%s, %s)", xCoord , yCoord);
                    System.out.format("Создан элемент с координатами: (%s, %s)\n", xCoord , yCoord);
                    return new TextField( captionTextField, xCoord, yCoord, width, height );
                default:
                    return null;
            }
        }

}
