package Task6;

public class Button extends Rectangle implements Rectangle.Clickable
{
    private ButtonClickCallback callback;

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

    public interface ButtonClickCallback
    {
        void onButtonClick();
    }

    @Override
    public void click() throws ReadOnlyException
    {
        if (state)
        {
            callback.onButtonClick();
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
