package com.task5.core.Elements.Templates;

import com.task5.core.Exceptions.UIInvalidSizeException;


public abstract class UIElement {
    private int x;
    private int y;
    private int width;
    private int height;
    private String name;
    private boolean disabled;

    protected static final String ENDL_CHAR = "%endl%";
    public abstract String toUISceneView();
    public abstract String getTypeName();

    public UIElement(int x, int y, int width, int height, String name, boolean disabled) throws UIInvalidSizeException {
        this.x = x;
        this.y = y;
        setWidth(width);
        setHeight(height);
        this.name = name;
        this.disabled = disabled;
    }

    public UIElement(int x, int y, int width, int height, String name) throws UIInvalidSizeException {
        this(x, y, width, height, name, false);
    }

    private boolean isSizeInvalid(int widthOrHeight) {
        return widthOrHeight <= 0;
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

    public void setWidth(int width) throws UIInvalidSizeException {
        if (isSizeInvalid(width))
            throw new UIInvalidSizeException(width, height);
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws UIInvalidSizeException {
        if (isSizeInvalid(height))
            throw new UIInvalidSizeException(width, height);
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public static String getEndlChar() {
        return ENDL_CHAR;
    }

    @Override
    public String toString() {
        return String.format("%s в координатах <%d, %d>, ширина %d, высота %d. Название: %s",
                             getTypeName(), x, y,  width, height, name);
    }
}
