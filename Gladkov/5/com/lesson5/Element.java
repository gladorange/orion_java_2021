package com.lesson5;

public abstract class Element {
   private int coordinateX;
   private int coordinateY;
   private int width;
   private int height;
   private String caption;
   private String type;
   private boolean state;


    public Element( String caption, String type, int coordinateX, int coordinateY, int width, int height ) {
        this.caption = caption;
        this.type = type;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.width = width;
        this.height = height;
    }


    public String getCaption() {
        return caption;
    }

    public String getType() {
        return type;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isState() {
        return state;
    }

    public Element setState( boolean state ) {
        this.state = state;
        return this;
    }
}
