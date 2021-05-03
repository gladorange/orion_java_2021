package orion2;

public class task {

    public static void main(String[] args) {
        // Case #1
        System.out.println();
        System.out.println("Case #1 (magic numbers) result: ");
        magicNumberTask();
        System.out.println();
        // Case #2
        System.out.println("Case #2 (neighbours) result: ");
        neighboursTask();
    }

    public static void magicNumberTask() {
        final int LOW_BOUND_CASE1 = -100;
        final int HIGH_BOUND_CASE1 = 100;
        final int ARR_SIZE = 100;
        int[] arr = new int[ARR_SIZE];
        for(int i = 0; i < ARR_SIZE; i++) {
            arr[i] = customGetRandom(LOW_BOUND_CASE1, HIGH_BOUND_CASE1);
        }
        for (int i : arr) {
            if(isMagicNumber(i))
                System.out.println("    Number " + i + " is magic!");
        }
    }

    public static boolean isMagicNumber(int number) {
        if(number / 10 == 0) return false;
        int inputNumber = number;
        int newNumber = 0;
        while(number != 0) {
            newNumber = newNumber * 10 + number % 10;
            number /= 10;
        }
        return (inputNumber == newNumber);
    }

    public static void neighboursTask() {
        final int INTEGER_MIN = -2147483648;
        final int INTEGER_MAX = 2147483647;
        final int ARR_SIZE = 10;
        int[] arr = new int[ARR_SIZE];
        for(int i = 0; i < ARR_SIZE; i++) {
            arr[i] = customGetRandom(INTEGER_MIN, INTEGER_MAX);
            if(i != 0) {
                if ((arr[i - 1] < 0 && arr[i] > 0) || (arr[i - 1] > 0 && arr[i] < 0)) {
                    System.out.println("    Numbers with opposite sign detected: " + arr[i - 1] + " " + arr[i]);
                }
            }
        }
    }

    public static int customGetRandom(int min, int max) {
        if (min > max){
            throw new IllegalArgumentException("Min " + min + " greater than max " + max);
        }
        return (int) ( (long) min + Math.random() * ((long)max - min + 1));
    }
}
