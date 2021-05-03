package orion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i1 = 0;
        int i2 = 0;

        System.out.println("Working with 32 bit primitive types..");
        try {
            System.out.print("Enter first integer: ");
            i1 = input.nextInt();
            System.out.print("Enter second integer: ");
            i2 = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid integer on input! Expected 32 bit value..");
            return;
        }

        String result = (i1 > i2) ? "First integer with value = " + i1 + " is larger than second integer with value = " + i2
                                  : "First integer with value = " + i1 + " is smaller than second integer with value = " + i2;
        System.out.println(result);

        try {
            System.out.println("Sum of two integers = " + Math.addExact(i1, i2));
        } catch (ArithmeticException e) {
            System.out.println("Integer over(under)flow on sum detected! Expected range in 32 bit..");
        }
    }
}
