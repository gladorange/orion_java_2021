package com.orion.java.hw5;

import java.util.Random;

class CheckBox extends Rectangle implements Clickable {
    private ButtonClickCallback callback;
    private boolean isPressed;

    public CheckBox(int x, int y, int weight, int height, String caption, boolean isActive, ButtonClickCallback callback) {
        super(x, y, weight, height, caption, isActive);
        this.callback = callback;
        isPressed = new Random().nextBoolean();
    }

    public boolean isPressed() {
        return isPressed;
    }

    @Override
    public void click() throws ReadOnlyException {
        if (this.isActive()) {
            this.isPressed = isPressed ? false : true;
            callback.onButtonClick();
        } else {
            throw new ReadOnlyException(this);
        }
    }
}
