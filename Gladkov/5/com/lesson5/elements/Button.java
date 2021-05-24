package com.lesson5.elements;

import com.lesson5.ButtonClickCallback;
import com.lesson5.Clickable;
import com.lesson5.Element;

public class Button extends Element implements Clickable {
    private ButtonClickCallback callback;


    public Button( String caption, int coordinateX, int coordinateY, int width, int height, ButtonClickCallback callback ) {
        super( caption, "Кнопка", coordinateX, coordinateY, width, height  );
        this.callback = callback;
    }


    @Override
    public void click() {
        callback.onButtonClick();
    }

}
