package Task2;

import java.util.Arrays;

public class MagicNumbers
{
    private static final int MIN_RANGE_VALUE = -100;
    private static final int MAX_RANGE_VALUE = 100;

    public static int getRandomNumberOfSomeRange()
    {
        int minValue = MIN_RANGE_VALUE < 0 ? MIN_RANGE_VALUE - 1 : MIN_RANGE_VALUE;
        int maxValue = MAX_RANGE_VALUE > 0 ? MAX_RANGE_VALUE + 1 : MAX_RANGE_VALUE;

        double randomNumber = Math.random();
        return (int) ((minValue * (1.0 - randomNumber)) + (maxValue * randomNumber));
    }

    public static boolean isMagicNumber(int number, int mod)
    {
        int nextMod = number%10;
        if (nextMod != mod)
        {
            return false;
        }
        number = number/10;

        return (number == 0 || isMagicNumber(number, nextMod));
    }

    public static void main(String[] args)
    {
        int[] arrayIntegers = new int[100];
        for (int i = 0; i < arrayIntegers.length; i++)
        {
            arrayIntegers[i] = getRandomNumberOfSomeRange();
        }

        for (int intNumber : arrayIntegers)
        {
            int number = intNumber/10;
            if (number != 0 && isMagicNumber(number, intNumber % 10))
            {
                System.out.println("Число " + intNumber + " - магическое!");
            }
        }
    }
}
