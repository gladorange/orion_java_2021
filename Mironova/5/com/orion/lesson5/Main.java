package com.orion.lesson5;

import com.orion.lesson5.elements.AddElementOnClick;
import com.orion.lesson5.elements.Button;
import com.orion.lesson5.elements.Element;
import com.orion.lesson5.elements.TextField;
import com.orion.lesson5.elements.interfaces.Clickable;
import com.orion.lesson5.exceptions.OutOfRangeException;
import com.orion.lesson5.exceptions.ReadOnlyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws OutOfRangeException, ReadOnlyException {

        Random rand = new Random();
        UI scene = new UI();

        System.out.println("Создаём стартовые элементы.");
        Button addElementButton = new Button(rand.nextInt(scene.MAX_X), rand.nextInt(scene.MAX_Y), rand.nextInt(Element.MAX_HEIGHT), rand.nextInt(Element.MAX_WEIGHT), "Добавить элемент", true, new AddElementOnClick(scene));
        TextField coordX = new TextField(rand.nextInt(scene.MAX_X), rand.nextInt(scene.MAX_Y), rand.nextInt(Element.MAX_HEIGHT), rand.nextInt(Element.MAX_WEIGHT), "Координата x для нового элемента", true, "");
        TextField coordY = new TextField(rand.nextInt(scene.MAX_X), rand.nextInt(scene.MAX_Y), rand.nextInt(Element.MAX_HEIGHT), rand.nextInt(Element.MAX_WEIGHT), "Координата y для нового элемента", true, "");
        System.out.println("Стартовые лементы успешно созданы.");


        System.out.println("Добавляем стартовые элементы на \"сцену\".");
        scene.addElement(addElementButton);
        scene.addElement(coordX);
        scene.addElement(coordY);

        System.out.println("Тестируем работу с элементами.");
        coordX.setText(Integer.toString(rand.nextInt(scene.MAX_X)));
        coordY.setText(Integer.toString(rand.nextInt(scene.MAX_Y)));
        addElementButton.click();
        System.out.println("Тестирование прошло успешно.");

        System.out.println("Запускаем работу с элементами ");
        for (int i = 0; i < 10; i++) {
            coordX.setText(Integer.toString(rand.nextInt(scene.MAX_X)));
            coordY.setText(Integer.toString(rand.nextInt(scene.MAX_Y)));
            addElementButton.click();
        }

        System.out.println(" и выводим созданные элементы: ");
        scene.getAllElements().stream()
                .forEach(e -> {
                    e.getDescription();
                    if (e instanceof Clickable) {
                        try {
                            ((Clickable) e).click();
                        } catch (OutOfRangeException ex) {
                            ex.printStackTrace();
                        } catch (ReadOnlyException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        ((TextField) e).getText();
                    }

                });
    }
}
