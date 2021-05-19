package com.lesson5;

import com.lesson5.elements.Button;
import com.lesson5.elements.CheckBox;
import com.lesson5.elements.TextField;

import java.util.Random;

public class AddElementOnClick implements ButtonClickCallback{
    private UI scene;


    public AddElementOnClick( UI sceneToAddElements ) {
        scene = sceneToAddElements;
    }


    @Override
    public void onButtonClick() {
        int coordinateX = Integer.parseInt(((TextField)scene.getAllElements().get(1)).getText());
        int coordinateY = Integer.parseInt(((TextField)scene.getAllElements().get(2)).getText());
            Element elementToAdd = generateRandomElement( coordinateX, coordinateY );
        scene.addElement( elementToAdd );
    }

    private int generateRandomNumber(){
        return new Random().nextInt(20 - 5) + 5;
    }

    private Element generateRandomElement( int coordinateX, int coordinateY ) {
        int randomNumber = new Random().nextInt( 3 );
        int width = generateRandomNumber();
        int height = generateRandomNumber();
            switch ( randomNumber ) {
                case 0:
                    String captionButton = "Кнопка в " + coordinateX + "," + coordinateY;
                    System.out.println( "Создан элемент с координатами: " + coordinateX + "," + coordinateY + ". ");
                    return new Button( captionButton, coordinateX, coordinateY, width, height, () ->
                            System.out.println("Нажата кнопка в " + coordinateX + "," + coordinateY + " с названием: "
                                    + captionButton ));
                case 1:
                    String captionCheckBox = "Галка в " + coordinateX + "," + coordinateY;
                    System.out.println( "Создан элемент с координатами: " + coordinateX + "," + coordinateY + ". " );
                    return new CheckBox( captionCheckBox, coordinateX, coordinateY, width, height, () ->
                            System.out.println( "Нажата галка в " + coordinateX + "," + coordinateY + " с названием: "
                                    + captionCheckBox ));
                case 2:
                    System.out.println( "Создан элемент с координатами: " + coordinateX + "," + coordinateY + ". " );
                    return new TextField( "Текстовое поле", coordinateX, coordinateY, width, height );
                default: return null;
            }
        }

}
