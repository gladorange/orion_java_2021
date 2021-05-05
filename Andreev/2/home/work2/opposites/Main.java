package home.work2.opposites;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random r = new Random();
        int[] intArray = r.ints(10).toArray();
        System.out.println(Arrays.toString(intArray));
        for (int i = 0; i < intArray.length; i++) {
            if (i != intArray.length - 1) {
                if (intArray[i] < 0 & intArray[i + 1] > 0) {
                    System.out.printf("Числа с противоположными знаками обнаружены: %d %d\n", intArray[i], intArray[i + 1]);
                }
                if (intArray[i] > 0 & intArray[i + 1] < 0) {
                    System.out.printf("Числа с противоположными знаками обнаружены: %d %d\n", intArray[i], intArray[i + 1]);
                }
            }
        }
    }
}
