package Task6;

import java.util.Random;

public class CheckBox extends Rectangle implements Rectangle.Clickable
{
    private boolean isChecked;

    CheckBox(String caption, int x, int y, int height, int width, boolean isChecked)
    {
        super(caption, x, y, height, width);
        this.isChecked = isChecked;
    }

    CheckBox(int x, int y)
    {
        super("Случайный чекбокс в <" + x + ", " + y + ">", x, y);
        isChecked = new Random().nextBoolean();
        System.out.println("Создан " + this);
    }

    public boolean isChecked() { return isChecked; }

    @Override
    public void click() throws ReadOnlyException
    {
        if (state)
        {
            isChecked = !isChecked;
            System.out.println("Меняем состояние isChecked чекбокса: " + isChecked);
        }
        else
        {
            throw new ReadOnlyException("Ex: Элемент " + this + " выключен.");
        }
    }

    @Override
    public String toString()
    {
        return "Чекбокс с координатами <" + x + ", " + y + ">, шириной <"
                + height + ">, высотой <" + width + ">, названием: " + caption
                + " и состоянием: " + state + ", isChecked: " + isChecked;
    }
}
