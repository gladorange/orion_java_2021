package Task3;

import java.util.Arrays;

public class AttractionOfOpposites
{
    private static final int MIN_RANGE_VALUE = Integer.MAX_VALUE;
    private static final int MAX_RANGE_VALUE = Integer.MIN_VALUE;

    public static int getRandomNumberOfSomeRange()
    {
        int minValue = MIN_RANGE_VALUE < 0 ? MIN_RANGE_VALUE - 1 : MIN_RANGE_VALUE;
        int maxValue = MAX_RANGE_VALUE > 0 ? MAX_RANGE_VALUE + 1 : MAX_RANGE_VALUE;

        double randomNumber = Math.random();
        return (int) ((minValue * (1.0 - randomNumber)) + (maxValue * randomNumber));
    }

    public  static boolean isOppositeNumbers(int number1, int number2)
    {
        if (number1 == 0 || number2 == 0)
        {
            return false;
        }
        return (((number1^number2) >> 31) & 1) == 1;
    }

    public static void main(String[] args)
    {
        int[] arrayIntegers = new int[10];
        for (int i = 0; i < arrayIntegers.length; i++)
        {
            arrayIntegers[i] = getRandomNumberOfSomeRange();
        }
        System.out.println("Значения массива: " + Arrays.toString(arrayIntegers));

        int firstValue = arrayIntegers[0];
        for (int i = 1; i < arrayIntegers.length; i++)
        {
            int secondValue = arrayIntegers[i];
            if (isOppositeNumbers(firstValue, secondValue))
            {
                System.out.println("Числа с противоположными знаками обнаружены: " + firstValue + ", " + secondValue);
            }
            firstValue = secondValue;
        }
    }
}
