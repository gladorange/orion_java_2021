package Task6;

import java.util.Random;

public class AddElementOnClick implements Button.ButtonClickCallback
{
    private UI scene;

    public AddElementOnClick(UI sceneToAddElements)
    {
        scene = sceneToAddElements;
    }

    private Rectangle generateRandomElement(int x, int y)
    {
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
    public void onButtonClick(int x, int y)
    {
        Rectangle toAdd = generateRandomElement(x, y);
        try {
            scene.checkIntersection(toAdd);
            scene.addElement(toAdd);
            System.out.println("Добавлен элемент " + toAdd);
        } catch (UI.ElementsOverlapException | UI.ElementsOutOfScene e)
        {
            System.out.println(e.getMessage());
        }
    }
}

class DoNothingOnClick implements Button.ButtonClickCallback
{
    @Override
    public void onButtonClick(int x, int y)
    {
        System.out.printf("Нажата кнопка в <%d,%d>, она ничего не создает.\n", x, y);
    }
}
