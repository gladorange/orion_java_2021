package com.lesson2.task2;

import com.lesson2.utils.NumbersManipulate;

public class OppositeNumbers extends NumbersManipulate {

    OppositeNumbers(int size) {
        super(size);
    }

    private boolean isOpposite(int prev, int current) {
        return (prev > 0 && current < 0) || (prev < 0 && current > 0);
    }

    public void iterate() {
        for (int i = 0; i < super.forSearchArray.length; i++) {
            if(i > 0) {
                int prev = super.forSearchArray[i-1];
                int current = super.forSearchArray[i];
                if(isOpposite(prev, current)) {
                    System.out.println("Числа с противоположными знаками обнаружены: " + prev + ", " + current);
                }
            }
        }
    }







}
