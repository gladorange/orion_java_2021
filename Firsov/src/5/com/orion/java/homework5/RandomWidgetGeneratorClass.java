package com.orion.java.homework5;


import com.orion.java.homework5.widgets.Button;
import com.orion.java.homework5.widgets.CheckBox;
import com.orion.java.homework5.widgets.TextField;

import java.util.Random;

public class RandomWidgetGeneratorClass {
    final static int TYPE_NUMBER_DEFAULT = 3;
    public static int generateRandomNumber(){
        return new Random().nextInt(20 - 5) + 5;
    }

    public static Widget generateRandomElement(int coordinateX, int coordinateY ) {
        int randomNumber = new Random().nextInt( TYPE_NUMBER_DEFAULT );
        int width = generateRandomNumber();
        int height = generateRandomNumber();
        switch ( randomNumber ) {
            case 0:
                String captionButton = "Кнопка в " + coordinateX + "," + coordinateY;
                System.out.println( "Создан элемент с координатами: " + coordinateX + "," + coordinateY + ". ");
                return new Button(coordinateX,coordinateY,width,height,(new Random()).nextBoolean(),captionButton,() -> System.out.println("Нажата кнопка в " + coordinateX + "," + coordinateY + " с названием: "
                        + captionButton ));

            case 1:
                String captionCheckBox = "Галка в " + coordinateX + "," + coordinateY;
                System.out.println( "Создан элемент с координатами: " + coordinateX + "," + coordinateY + ". " );
                return new CheckBox(coordinateX,coordinateY,width,height,(new Random()).nextBoolean(),captionCheckBox,(new Random()).nextBoolean(),new EventHandler() {
                int currentId = Widget.ID_WIDGET;
                @Override
                public void execute() {
                    Widget.UI ui = Widget.UI.getInstance();
                    CheckBox checkBox =(CheckBox) ui.getAllElements().get(currentId);
                    boolean isPressed = checkBox.isPressed();
                    if(checkBox.isPressed()){
                        checkBox.setPressed(false);
                    }else{
                        checkBox.setPressed(true);
                    }
                    System.out.println( "Нажата галка в " + coordinateX + "," + coordinateY + " с названием: "
                            + captionCheckBox );
                }
            }) ;

            case 2:
                System.out.println( "Создан элемент с координатами: " + coordinateX + "," + coordinateY + ". " );
                return new TextField(coordinateX,coordinateY,width,height,(new Random()).nextBoolean(),"Текстовое поле",   String.valueOf((new Random()).nextInt(100) ));
            default: return null;
        }
    }


}
