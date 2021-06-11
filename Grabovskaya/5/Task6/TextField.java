package Task6;

import java.util.Random;

public class TextField extends Rectangle
{
    static final int LEFT_LIMIT = 97;
    static final int RIGHT_LIMIT = 123;
    static final int MAX_STRING_LENGTH = 11;

    private int coordinate;

    public TextField(String caption, int x, int y, int height, int width, int coordinate)
    {
        super(caption, x, y, height, width);
        this.coordinate = coordinate;
    }

    public TextField(int x, int y)
    {
        super(getRandomString(), x, y);
        System.out.println("Создан " + this);
    }

    public void setCoordinate(int coordinate)
    {
        this.coordinate = coordinate;
    }

    public int getCoordinate()
    {
        return coordinate;
    }

    private static String getRandomString()
    {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(MAX_STRING_LENGTH);
        for (int i = 0; i < MAX_STRING_LENGTH; i++)
        {
            int randomLimitedInt = LEFT_LIMIT + (int)(random.nextFloat() * (RIGHT_LIMIT - LEFT_LIMIT));
            buffer.append((char)randomLimitedInt);
        }
        return buffer.toString();
    }

    @Override
    public String toString()
    {
        return "Текстовое поле с координатами <" + x + ", " + y + ">, шириной <"
                + height + ">, высотой <" + width + ">, названием: " + caption
                + " и состоянием " + state;
    }
}
