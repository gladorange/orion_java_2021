package Task6;

import java.util.Random;

public abstract class Rectangle
{
    final protected int x;
    final protected int y;
    final protected int width;
    final protected int height;
    final protected String caption;

    protected boolean state = true;

    Rectangle(String caption, int x, int y, int height, int width)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.caption = caption;
    }

    Rectangle(String caption, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.caption = caption;

        Random random = new Random();
        width = random.nextInt(UI.MAX_WIDTH / 2);
        height = random.nextInt(UI.MAX_HEIGHT / 2);
        state = random.nextBoolean();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public interface Clickable
    {
        void click() throws Rectangle.ReadOnlyException;
    }

    public static class ReadOnlyException extends Exception
    {
        public ReadOnlyException(String errorMessage)
        {
            super(errorMessage);
        }
    }
}
