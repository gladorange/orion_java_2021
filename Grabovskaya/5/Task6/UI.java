package Task6;

import java.util.ArrayList;
import java.util.List;

public class UI
{
    final static public int MAX_WIDTH = 100;
    final static public int MAX_HEIGHT = 100;

    private List<Rectangle> elements = new ArrayList<>();

    public List<Rectangle> getAllElements()
    {
        return elements;
    }

    public void checkIntersection(Rectangle element) throws ElementsOverlapException, ElementsOutOfScene
    {
        int x = element.getX();
        int y = element.getY();
        int width = element.getWidth();
        int height = element.getHeight();

        if ((x + width) > UI.MAX_WIDTH || (y + height) > UI.MAX_HEIGHT)
        {
            throw new ElementsOutOfScene("Ex: Элемент " + element + " не может быть добавлен, потому что выходит за пределы сцены");
        }

        for (Rectangle rectangle : elements)
        {
            int distanceX = Math.abs(rectangle.getX() - x);
            int distanceY = Math.abs(rectangle.getY() - y);
            int averageW = (width + rectangle.getWidth()) / 2;
            int averageH = (height + rectangle.getHeight()) / 2;

            if (distanceX <= averageW && distanceY <= averageH)
            {
                throw new ElementsOverlapException("Ex: Элемент " + element + " не может быть добавлен, так как пересекается с элементом " + rectangle);
            }
        }
    }

    public void addElement(Rectangle element)
    {
        elements.add(element);
    }

    public static class ElementsOverlapException extends Exception
    {
        public ElementsOverlapException(String errorMessage)
        {
            super(errorMessage);
        }
    }

    public static class ElementsOutOfScene extends Exception
    {
        public ElementsOutOfScene(String errorMessage)
        {
            super(errorMessage);
        }
    }
}
