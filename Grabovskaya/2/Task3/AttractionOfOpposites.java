package Task3;

import java.util.Arrays;

public class AttractionOfOpposites
{
    private static final int MinRangeValue = Integer.MAX_VALUE;
    private static final int MaxRangeValue = Integer.MIN_VALUE;

    public static int getRandomNumberOfSomeRange()
    {
        int minValue = MinRangeValue < 0 ? MinRangeValue - 1 : MinRangeValue;
        int maxValue = MaxRangeValue > 0 ? MaxRangeValue + 1 : MaxRangeValue;

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
