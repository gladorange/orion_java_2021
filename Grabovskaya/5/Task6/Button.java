package Task6;

public class Button extends Rectangle implements Rectangle.Clickable
{
    private ButtonClickCallback callback;
    private int coordinateXForNewElement = 0;
    private int coordinateYForNewElement = 0;

    public Button(String caption, int x, int y, int height, int width, ButtonClickCallback callback)
    {
        super(caption, x, y, height, width);
        this.callback = callback;
    }

    public Button(int x, int y, ButtonClickCallback callback)
    {
        super("Случайная кнопка в <" + x + ", " + y + ">", x, y);
        this.callback = callback;
        System.out.println("Создана " + this);
    }

    public ButtonClickCallback getCallback()
    {
        return callback;
    }

    public void setCoordinateXForNewElement(int coordinateXForNewElement)
    {
        this.coordinateXForNewElement = coordinateXForNewElement;
    }

    public void setCoordinateYForNewElement(int coordinateYForNewElement)
    {
        this.coordinateYForNewElement = coordinateYForNewElement;
    }

    public interface ButtonClickCallback
    {
        void onButtonClick(int x, int y);
    }

    @Override
    public void click() throws ReadOnlyException
    {
        if (state)
        {
            callback.onButtonClick(coordinateXForNewElement, coordinateYForNewElement);
        }
        else
        {
            throw new ReadOnlyException("Ex: Элемент " + this + " выключен.");
        }
    }

    @Override
    public String toString()
    {
        return "Кнопка с координатами <" + x + ", " + y + ">, шириной <"
                + height + ">, высотой <" + width + ">, названием: " + caption
                + " и состоянием " + state;
    }
}
