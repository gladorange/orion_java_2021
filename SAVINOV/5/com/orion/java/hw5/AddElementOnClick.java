package com.orion.java.hw5;

import java.util.Random;

public class AddElementOnClick implements ButtonClickCallback {
    UI ui;

    AddElementOnClick(UI sceneToAddElements) {
        ui = sceneToAddElements;
    }

    @Override
    public void onButtonClick() {
        if (ui.getAllElements().size() >= 3) {
            try {
                int x = Integer.parseInt(((TextField) ui.getAllElements().get(1)).getText());
                int y = Integer.parseInt(((TextField) ui.getAllElements().get(2)).getText());
                Rectangle toAdd = getRandomElement(x, y);
                checkPosition(toAdd);
                ui.addElement(toAdd);
            } catch (ElementOverlapException e) {
                e.printStackTrace();
            }
        }
    }

    private Rectangle getRandomElement(int x, int y) {
        int random = new Random().nextInt(3);
        int height = new Random().nextInt(10);
        int weight = new Random().nextInt(15);
        switch (random) {
            case 0:
                String captionBtn = "Button в (" + x + ";" + y + ")";
                return new Button(x, y, weight, height, captionBtn, true, () -> System.out.println("Нажата кнопка в (" + x + ";" + y + ") с названием \"" + captionBtn + "\""));
            case 1:
                String captionCheckBox = "CheckBox в (" + x + ";" + y + ")";
                return new CheckBox(x, y, weight, height, captionCheckBox, true, () -> {
                    System.out.println("Нажата CheckBox в (" + x + ";" + y + ") с названием \"" + captionCheckBox + "\"");
                });
            case 2:
                String captionTextField = "TextField в (" + x + ";" + y + ")";
                return new TextField(x, y, height, weight, captionTextField, true, "");
            default:
                return null;
        }
    }

    private void checkPosition(Rectangle newElement) throws ElementOverlapException {
        for (Rectangle oldElement : ui.getAllElements()) {
            if ((oldElement.getX() + oldElement.getWeight()) < newElement.getX()
                    || (newElement.getX() + newElement.getWeight()) < oldElement.getX()
                    || (oldElement.getY() + oldElement.getHeight()) < newElement.getY()
                    || (newElement.getY() + newElement.getWeight()) < oldElement.getY()) {
            } else {
                throw new ElementOverlapException(newElement, oldElement);
            }
        }
    }
}
