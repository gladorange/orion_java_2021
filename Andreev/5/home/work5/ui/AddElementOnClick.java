package home.work5.ui;

import home.work5.exceptions.ElementGoesAbroadException;
import home.work5.exceptions.ElementsOverlapException;
import home.work5.rectangle.*;

import java.util.Random;

public class AddElementOnClick implements ButtonClickCallback {

    private UserInterface ui;

    public AddElementOnClick(UserInterface sceneToAddElements) {
        ui = sceneToAddElements;
    }

    @Override
    public void onButtonClick() {
        TextField textFieldX = (TextField) ui.getAllElements().get(1);
        TextField textFieldY = (TextField) ui.getAllElements().get(2);
        try {
            Rectangle element = generateRandomElement(Integer.parseInt(textFieldX.getText()), Integer.parseInt(textFieldY.getText()));
            ui.addElement(element);
        } catch (ElementsOverlapException | ElementGoesAbroadException e) {
            e.printStackTrace();
        }
    }

    private Rectangle generateRandomElement(int x, int y) throws ElementsOverlapException, ElementGoesAbroadException {
        int number = new Random().nextInt(3);
        int height = getRandomNumber();
        int width = getRandomNumber();
        checkPosition(x, y, width, height);
        switch (number) {
            case 0:
                String caption = "Кнопка в " + x + "," + y;
                System.out.println("Создан элемент с координатами: " + x + "," + y + ". ");
                return new Button(x, y, width, height, caption, () ->
                        System.out.println("Нажата кнопка в " + x + "," + y + " с названием: " + caption));
            case 1:
                String captionCheck = "Галка в " + x + "," + y;
                System.out.println("Создан элемент с координатами: " + x + "," + y + ". ");
                return new CheckBox(x, y, width, height, captionCheck, () ->
                        System.out.println("Нажата галка в " + x + "," + y + " с названием: " + captionCheck));
            case 2:
                System.out.println("Создан элемент с координатами: " + x + "," + y + ". ");
                return new TextField(x, y, width, height, "TextField");
            default:
                return null;
        }
    }

    private void checkPosition(int x, int y, int width, int height) throws ElementsOverlapException, ElementGoesAbroadException {

        if (x - height < 1 || y + width > 100) {
            throw new ElementGoesAbroadException("Элемент выходит за границы интерфейса!");
        }

        //проверяем каждую вершину нового элемента на пересечение с уже существующими
        for (Rectangle el : ui.getAllElements()) {
            if ((x < el.getX() & x > el.getX() - el.getHeight() & y > el.getY() & y < el.getY() + el.getWidth())
                    || (x < el.getX() & x > el.getX() - el.getHeight() & y + width > el.getY() & y + width < el.getY() + el.getWidth())
                    || (x - height < el.getX() & x - height > el.getX() - el.getHeight() & y > el.getY() & y < el.getY() + el.getWidth())
                    || (x - height < el.getX() & x - height > el.getY() - el.getHeight() & y + width < el.getY() + el.getWidth() & y + width > el.getY())) {
                throw new ElementsOverlapException("Елемент пересекается с существующим элементом!");
            }
        }
    }

    private int getRandomNumber() {
        int number = new Random().nextInt(15);
        if (number == 0) {
            number = getRandomNumber();
        }
        return number;
    }
}
