package com.lesson5.task1.elements;

import com.lesson5.task1.abstractions.ButtonClickCallback;
import com.lesson5.task1.abstractions.Clickable;
import com.lesson5.task1.abstractions.Element;
import com.lesson5.task1.abstractions.ElementType;
import com.lesson5.task1.exceptions.ReadOnlyException;

import java.util.Random;

public class CheckBox extends Element implements Clickable {
    private ButtonClickCallback callback;
    private boolean checked;


    public CheckBox( String caption, int xCoord, int yCoord, int width, int height, ButtonClickCallback callback ) {
        super( caption, ElementType.CHECK_BOX, xCoord, yCoord, width, height );
        this.callback = callback;
        checked = new Random().nextBoolean();
    }


    public boolean checked() {
        return checked;
    }


    @Override
    public void click() throws ReadOnlyException {
        if ( this.isActive() ) {
            callback.onButtonClick();
        } else {
            throw new ReadOnlyException( this );
        }
    }
}
