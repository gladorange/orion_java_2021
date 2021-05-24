package com.lesson5.elements;

import com.lesson5.ButtonClickCallback;
import com.lesson5.Clickable;
import com.lesson5.Element;
import com.lesson5.exceptions.ReadOnlyException;

import java.util.Random;

public class CheckBox extends Element implements Clickable {
    private ButtonClickCallback callback;
    private boolean isClick;


    public CheckBox( String caption, int coordinateX, int coordinateY, int width, int height, ButtonClickCallback callback ) {
        super( caption, "Галка", coordinateX, coordinateY, width, height );
        this.callback = callback;
        isClick = new Random().nextBoolean();
    }


    public boolean isClick() {
        return isClick;
    }


    @Override
    public void click() throws ReadOnlyException {
        if ( this.isClick() ) {
            callback.onButtonClick();
        } else {
            setState( !this.isClick() );
            throw new ReadOnlyException( this );
        }
    }
}
