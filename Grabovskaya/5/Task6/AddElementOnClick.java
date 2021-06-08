package Task6;

import java.util.Random;

public class AddElementOnClick implements Button.ButtonClickCallback
{
    private UI scene;

    public AddElementOnClick(UI sceneToAddElements)
    {
        scene = sceneToAddElements;
    }

    private Rectangle generateRandomElement()
    {
        int x = ((TextField)scene.getAllElements().get(1)).getCoordinate();
        int y = ((TextField)scene.getAllElements().get(2)).getCoordinate();

        Rectangle newElement = null;
        final int numberDifferentRec = 3;
        switch (new Random().nextInt(numberDifferentRec))
        {
            case 0:
                newElement = new Button(x, y, new DoNothingOnClick());
                break;
            case 1:
                newElement = new CheckBox(x, y);
                break;
            case 2:
                newElement = new TextField(x, y);
                break;
        }
        return newElement;
    }

    @Override
    public void onButtonClick()
    {
        Rectangle toAdd = generateRandomElement();
        scene.addElement(toAdd);
        System.out.println("Добавлен элемент " + toAdd);
    }
}

class DoNothingOnClick implements Button.ButtonClickCallback
{
    @Override
    public void onButtonClick()
    {
        System.out.println("Нажата кнопка, которая ничего не создает");
    }
}
