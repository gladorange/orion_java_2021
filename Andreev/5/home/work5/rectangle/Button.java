package home.work5.rectangle;

public class Button extends Rectangle implements Clickable {

    private ButtonClickCallback callback;

    public Button(int x, int y, int width, int height, String caption, ButtonClickCallback callback) {
        super(x, y, width, height, caption);
        this.callback = callback;
    }

    @Override
    public void click() {
        callback.onButtonClick();
    }
}
