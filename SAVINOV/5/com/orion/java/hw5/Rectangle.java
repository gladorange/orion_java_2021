package com.orion.java.hw5;

abstract class Rectangle {
    private int x;
    private int y;
    private int weight;
    private int height;
    private String caption;
    private boolean isActive;

    public Rectangle(int x, int y, int weight, int height, String caption, boolean isActive) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.caption = caption;
        this.isActive = isActive;
    }

    public String getCaption() {
        return caption;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public boolean isActive() {
        return isActive;
    }
}
