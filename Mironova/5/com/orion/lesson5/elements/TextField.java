package com.orion.lesson5.elements;

public class TextField extends Element {

    private String text;

    public TextField(int x, int y, int height, int weight, String caption, boolean state, String text) {
        super(x, y, height, weight, caption, true);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
