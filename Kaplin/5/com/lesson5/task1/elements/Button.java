package com.lesson5.task1.elements;

import com.lesson5.task1.abstractions.ButtonClickCallback;
import com.lesson5.task1.abstractions.Clickable;
import com.lesson5.task1.abstractions.Element;
import com.lesson5.task1.abstractions.ElementType;
import com.lesson5.task1.exceptions.ReadOnlyException;

public class Button extends Element implements Clickable {
    private ButtonClickCallback callback;


    public Button( String caption, int xCoord, int yCoord, int width, int height, ButtonClickCallback callback ) {
        super( caption, ElementType.BUTTON, xCoord, yCoord, width, height  );
        this.callback = callback;
    }


    @Override
    public void click() throws ReadOnlyException {
        if(this.isActive()) {
            callback.onButtonClick();
        } else {
            throw new ReadOnlyException(this);
        }

    }

}
