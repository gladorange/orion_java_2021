package Task1;

public class ComparisonTwoNumbers {

    public static void main(String[] args) {
        Integer number1 = 5;
        Integer number2 = 9;

        if (number1.compareTo(number2) > 0)
        {
            System.out.println("Число " + number1 + " больше " + number2);
        }
        else if (number1.compareTo(number2) < 0)
        {
            System.out.println("Число " + number1 + " меньше " + number2);
        }

        System.out.println("Сумма чисел = " + (number1 + number2));
    }
}
