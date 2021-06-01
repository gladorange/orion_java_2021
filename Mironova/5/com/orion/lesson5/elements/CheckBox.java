package com.orion.lesson5.elements;

import com.orion.lesson5.elements.interfaces.Clickable;
import com.orion.lesson5.exceptions.ReadOnlyException;

public class CheckBox extends Element implements Clickable {

    public CheckBox(int x, int y, int height, int weight, String caption, boolean state) {
        super(x, y, height, weight, caption, state);
    }

    @Override
    public void click() throws ReadOnlyException {

        if(!this.isState()){
            throw new ReadOnlyException(this);
        }

        this.setState(!this.isState());
    }
}
