package com.orion.lesson4.inheritance;

public class Button {

    FigureManager figureManager;

    public Button(int x, int y, int width, int height) {
        figureManager = new FigureManager(x, y, width, height);
        if (!figureManager.isValid()) {
            throw new IllegalArgumentException();
        }

    }

    public static void main(String[] args) {
        Button b = new Button(-1, 0, 0, 0);
    }
}
