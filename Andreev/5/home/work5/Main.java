package home.work5;

import home.work5.exceptions.ReadOnlyException;
import home.work5.rectangle.*;
import home.work5.ui.AddElementOnClick;
import home.work5.ui.UserInterface;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();

        Button addButton = new Button(100, 15, 8, 4, "Добавить элемент", new AddElementOnClick(userInterface));
        TextField textFieldX = new TextField(100, 1, 6, 2, "Координата x для нового элемента");
        TextField textFieldY = new TextField(100, 8, 6, 2, "Координата y для нового элемента");
        userInterface.addElement(addButton);
        userInterface.addElement(textFieldX);
        userInterface.addElement(textFieldY);

        System.out.println("Создание элементов интерфейса.............");
        for (int i = 0; i < 10; i++) {
            textFieldX.setText(String.valueOf(new Random().nextInt(100)));
            textFieldY.setText(String.valueOf(new Random().nextInt(100)));
            addButton.click();
        }
        System.out.println("Элементы интерфейса созданы!");

        List<Rectangle> list = userInterface.getAllElements();

        System.out.println("Перебираем элементы интерфейса............");
        for (int i = 3; i < list.size(); i++) {
            System.out.println(list.get(i).getClass().getSimpleName() + " в координатах "
                    + list.get(i).getX() + "," + list.get(i).getY() + ", ширина " + list.get(i).getWidth()
                    + ", высота " + list.get(i).getHeight() + ", Название: " + list.get(i).getCaption());
            if (list.get(i) instanceof Button || list.get(i) instanceof CheckBox) {
                try {
                    ((Clickable) list.get(i)).click();
                } catch (ReadOnlyException ex) {
                    ex.printStackTrace();
                }
                if (list.get(i) instanceof CheckBox) {
                    System.out.println("Состояние галки: " + list.get(i).isState());
                }
            } else {
                TextField textField = (TextField) list.get(i);
                System.out.println("Текстовое поле содержит следующий текст: " + textField.getText());
            }

        }
        System.out.println("Конец!");
    }
}
