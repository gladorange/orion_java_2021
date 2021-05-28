package com.orion.java.hw5;

import java.util.ArrayList;
import java.util.List;

public class UI {

    public static final int UI_HEIGHT = 100;
    public static final int UI_WEIGHT = 100;

    private List<Rectangle> rectangleList = new ArrayList<>();

    public List<Rectangle> getAllElements() {
        return rectangleList;
    }

    public void addElement(Rectangle rectangle) {
        if (rectangle.isActive()) {
            rectangleList.add(rectangle);
        } else {
            try {
                throw new ReadOnlyException(rectangle);
            } catch (ReadOnlyException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayAllElements() {
        for (int i = 0; i < rectangleList.size(); i++) {
            System.out.println(rectangleList.get(i).getClass().getSimpleName() + " в координатах ("
                    + rectangleList.get(i).getX() + ";" + rectangleList.get(i).getY() + "), ширина " + rectangleList.get(i).getWeight()
                    + ", высота " + rectangleList.get(i).getHeight() + ", Название: \"" + rectangleList.get(i).getCaption() + "\"");

            if (i == 0) {
                continue;
            }

            if (rectangleList.get(i) instanceof Button || rectangleList.get(i) instanceof CheckBox) {
                try {
                    ((Clickable) rectangleList.get(i)).click();
                } catch (ReadOnlyException e) {
                    e.printStackTrace();
                }

                if (rectangleList.get(i) instanceof CheckBox) {
                    System.out.println("Состояние CheckBox после клика: " + ((CheckBox) rectangleList.get(i)).isPressed());
                }
            } else {
                TextField textField = (TextField) rectangleList.get(i);
                System.out.println("TextField: " + textField.getText());
            }
        }
    }
}
