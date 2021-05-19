package home.work5.rectangle;

import java.util.Random;

public abstract class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;
    private String caption;
    private boolean state;

    public Rectangle(int x, int y, int width, int height, String caption) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.caption = caption;
        this.state = new Random().nextBoolean();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
