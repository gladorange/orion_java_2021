package com.orion.java.lesson2;

public class OppositeSignsTask extends ArrayTask {

    public OppositeSignsTask(String taskName, int arraySize) {
        super(taskName, arraySize);
    }

    void getResult() {

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == 0) {
                continue;
            }
            if ((i+1 < this.array.length) && this.isOppositeSign(this.array[i], this.array[i+1])) {
                System.out.println("Числа с противоположными знаками обнаржены: " + this.array[i] + " и " + this.array[i+1]);
            }
        }
    }

    private boolean isOppositeSign(int i, int j) {

        return ((i * j) < 0);

    }

}
