package com.lesson5.task1.abstractions;

public abstract class Element {
    private int xCoord;
    private int yCoord;
    private int width;
    private int height;
    private String caption;
    private ElementType type;
    private boolean active = true;


    public Element(String caption, ElementType type, int xCoord, int yCoord, int width, int height) {
        this.caption = caption;
        this.type = type;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = width;
        this.height = height;
    }


    public String getCaption() {
        return caption;
    }

    public ElementType getType() {
        return type;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isActive() {
        return active;
    }

    public void disableElement() {
        active = false;
    }

    public void enableElement() {
        active = true;
    }

    @Override
    public String toString() {
        return String.format("%s в координатах ( %s, %s ), шрина: %s высота: %s, название %s", type.toString(), xCoord, yCoord, width, height, caption);
    }

}
