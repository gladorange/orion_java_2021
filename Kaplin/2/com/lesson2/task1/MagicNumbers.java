package com.lesson2.task1;

import com.lesson2.utils.NumbersManipulate;

public class MagicNumbers extends NumbersManipulate {

    MagicNumbers(int size, int min, int max) {
        super(size, min, max);
    }

    private boolean isMagicNumber(int number) {

        return number != 0 && ((number/10) == number%10);
    }
    public void iterate() {
        for (int number : super.forSearchArray) {
            boolean isMagic = isMagicNumber(number);
            if(isMagic) {
                System.out.println("Число " + number + " магическое");
            }
        }
    }

}
