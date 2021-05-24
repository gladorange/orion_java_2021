package com.lesson5;

import com.lesson5.elements.Button;
import com.lesson5.elements.CheckBox;
import com.lesson5.elements.TextField;
import com.lesson5.exceptions.ReadOnlyException;

import java.util.List;
import java.util.Random;

public class AppMain {
    public static void main(String[] args) {
        UI scene = new UI();

        Button addButton = new Button("Добавить элемент",80, 30, 8, 4,  new AddElementOnClick(scene) );
        TextField textFieldX = new TextField( "Координата x для нового элемента", 50, 10, 6, 2 );
        TextField textFieldY = new TextField("Координата y для нового элемента", 40, 20, 8, 4 );
        scene.addElement(addButton);
        scene.addElement(textFieldX);
        scene.addElement(textFieldY);

        System.out.println("/**********Генерация элементов интерфейса.************/");
        for (int i = 0; i < 10; i++) {
            textFieldX.setText(String.valueOf(new Random().nextInt(UI.MAX_SIZE_X)));
            textFieldY.setText(String.valueOf(new Random().nextInt(UI.MAX_SIZE_Y)));
            addButton.click();
        }
        System.out.println("/**********Все элементы интерфейса сгенерированы.************/");

        List<Element> allElements = scene.getAllElements();

        System.out.println("/**********Перебор элементов интерфейса.************/");
        for ( int i = 0; i < allElements.size(); i++ ) {
            System.out.println( allElements.get(i).getType() + " в координатах "
                    + allElements.get(i).getCoordinateX() + "," + allElements.get(i).getCoordinateY() + ", ширина " + allElements.get(i).getWidth()
                    + ", высота " + allElements.get(i).getHeight() + ", Название: " + allElements.get(i).getCaption() );

            if( i == 0 ){ continue; }

            if ( allElements.get(i) instanceof Button || allElements.get(i) instanceof CheckBox ) {
                try {
                    ((Clickable) allElements.get(i)).click();
                } catch ( ReadOnlyException ex ) {
                    ex.printStackTrace();
                }
                if (allElements.get(i) instanceof CheckBox) {
                    System.out.println("Состояние галки после клика: " + allElements.get(i).isState() );
                }
            } else {
                TextField textField = (TextField) allElements.get(i);
                System.out.println("Текстовое поле содержит следующий текст: " + textField.getText());
            }

        }
        System.out.println("Конец!");
    }
}
