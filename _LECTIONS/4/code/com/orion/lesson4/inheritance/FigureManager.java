package com.orion.lesson4.inheritance;

public class FigureManager {

    int x;
    int y;
    int width;
    int height;


    public FigureManager(int x, int y, int width, int height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isValid() {
        return x >= 0;
    }
}
