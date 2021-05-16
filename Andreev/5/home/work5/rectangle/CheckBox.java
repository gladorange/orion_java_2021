package home.work5.rectangle;

import home.work5.exceptions.ReadOnlyException;

import java.util.Random;

public class CheckBox extends Rectangle implements Clickable {
    private boolean isPressed;
    private ButtonClickCallback callback;

    public CheckBox(int x, int y, int width, int height, String caption, ButtonClickCallback callback) {
        super(x, y, width, height, caption);
        this.callback = callback;
        isPressed = new Random().nextBoolean();
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    @Override
    public void click() throws ReadOnlyException {
        if (this.isState()) {
            callback.onButtonClick();
        } else {
            throw new ReadOnlyException("Элемент " + this.getCaption() + " предназначен только для чтения!");
        }
    }
}
