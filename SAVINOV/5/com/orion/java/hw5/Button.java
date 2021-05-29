package com.orion.java.hw5;

public class Button extends Rectangle implements Clickable {
    private ButtonClickCallback callback;

    public Button(int x, int y, int weight, int height, String caption, boolean isActive, ButtonClickCallback callback) {
        super(x, y, weight, height, caption, isActive);
        this.callback = callback;
    }

    @Override
    public void click() {
        if (this.isActive()) {
            callback.onButtonClick();
        }
    }
}
