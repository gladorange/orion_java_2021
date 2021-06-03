package Task6;

import java.util.List;
import java.util.Random;

public class UIMain
{
    public static void main(String[] args)
    {
        UI scene = new UI();
        Button addButton = new Button("Добавить элемент", 0, 0, 10, 20, new AddElementOnClick(scene));
        scene.addElement(addButton);
        TextField coordinateX = new TextField("Координата x для нового элемента", 0, 11, 5, 20, 0);
        TextField coordinateY = new TextField("Координата y для нового элемента", 21, 11, 5, 20, 20);
        scene.addElement(coordinateX);
        scene.addElement(coordinateY);
        addButton.setCoordinateXForNewElement(coordinateX.getCoordinate());
        addButton.setCoordinateYForNewElement(coordinateY.getCoordinate());
        try {
            addButton.click();
        } catch (Rectangle.ReadOnlyException e)
        {
            System.out.println(e.getMessage());
        }

        Random random = new Random();
        System.out.println("--------------Добавление элементов--------------");
        for (int i = 0; i < 10; i++)
        {
            coordinateX.setCoordinate(random.nextInt(UI.MAX_WIDTH));
            coordinateY.setCoordinate(random.nextInt(UI.MAX_HEIGHT));
            addButton.setCoordinateXForNewElement(coordinateX.getCoordinate());
            addButton.setCoordinateYForNewElement(coordinateY.getCoordinate());
            try {
                addButton.click();
            } catch (Rectangle.ReadOnlyException e)
            {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\n--------------Обход элементов--------------");
        List<Rectangle> elements = scene.getAllElements();
        for (Rectangle element : elements)
        {
            System.out.println(element);

            if (element instanceof Button && ((Button) element).getCallback() instanceof AddElementOnClick)
            {
                continue;
            }

            if (element instanceof Rectangle.Clickable)
            {
                try {
                    System.out.println("Кликаем");
                    ((Rectangle.Clickable) element).click();
                } catch (Rectangle.ReadOnlyException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (element instanceof CheckBox)
            {
                System.out.println("Состояние isChecked после клика: " + ((CheckBox) element).isChecked());
            }
            else if (element instanceof TextField)
            {
                System.out.println("Координата: " + ((TextField) element).getCoordinate());
            }
        }
    }
}
