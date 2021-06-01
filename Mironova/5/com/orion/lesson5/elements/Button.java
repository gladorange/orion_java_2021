package com.orion.lesson5.elements;

import com.orion.lesson5.elements.interfaces.ButtonClickCallback;
import com.orion.lesson5.elements.interfaces.Clickable;
import com.orion.lesson5.exceptions.OutOfRangeException;
import com.orion.lesson5.exceptions.ReadOnlyException;

public class Button extends Element implements Clickable {

    private ButtonClickCallback callback;

    public Button(int x, int y, int height, int weight, String caption, boolean state, ButtonClickCallback callback) {
        super(x, y, height, weight, caption, state);
        this.callback = callback;
    }

    @Override
    public void click() throws OutOfRangeException {

        //чтобы не было прекращения работы после выбрасывания исключения
        if(!this.isState()){
            try {
                throw new ReadOnlyException(this);
            } catch (ReadOnlyException e) {
                System.out.println(e.getMessage());
            }
        }

        callback.onButtonClick();
    }

}
