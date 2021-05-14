package com.orion.lesson5;

public class ExceptionExample {

    public static void main(String[] args) {
        System.out.println("Начало");
        try {
            IntegerHolder value = getIntegerHolder();

            System.out.println(42 / value.divisor);
        } catch (NullPointerException e) {
            System.out.println("Случился NPE");
        } catch (ArithmeticException e) {
            System.out.println("Случилось деление на ноль");
        } catch (Exception e) {
            System.out.println("Произошло что-то плохое:" + e.getClass().getName() + " , номер строки:" +
                            e.getStackTrace()[0].getClassName() +":"+
                    e.getStackTrace()[0].getLineNumber());
        }
        System.out.println("Конец");
    }

    private static IntegerHolder getIntegerHolder() {
        if (true) {
            throw new AssertionError();
        }

        String someString = null;
        return new IntegerHolder(Integer.parseInt(someString));
    }


    public static class IntegerHolder {
        int divisor;

        public IntegerHolder(int divisor) {
            this.divisor = divisor;
        }
    }
}
