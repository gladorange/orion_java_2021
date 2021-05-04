package home.work2.magicnumbers;

public class Main {

    public static void main(String[] args) {

        int[] intArray = new int[99];
        int min = -100, max = 100;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * ((max - min) + 1)) + min;
            if (isMagicNumber(intArray[i])) {
                System.out.printf("Число %d - магическое!\n", intArray[i]);
            }
        }
    }

    static boolean isMagicNumber(int number) {
        int total = number / 10;
        int fract = number % 10;
        return total == fract;
    }
}
