package com.task5.core.Elements;

import com.task5.core.Elements.Templates.ClickCallback;
import com.task5.core.Elements.Templates.Clickable;
import com.task5.core.Elements.Templates.UIElement;
import com.task5.core.Exceptions.UIInvalidSizeException;

public class CheckBox extends UIElement implements Clickable {
    private static final String TYPE_NAME      = "Checkbox";
    private static final String STATE_ON_CHAR  = "■";
    private static final String STATE_OFF_CHAR = "□";

    private boolean stateOn;
    private ClickCallback clickCallback;

    public CheckBox(int x, int y, int width, int height, String name, boolean disabled, ClickCallback clickCallback, boolean stateOn) throws UIInvalidSizeException {
        super(x, y, width, height, name, disabled);
        this.clickCallback = clickCallback;
        this.stateOn = stateOn;
    }

    public CheckBox(int x, int y, int width, int height, String name, ClickCallback clickCallback) throws UIInvalidSizeException {
        super(x, y, width, height, name);
        this.clickCallback = clickCallback;
        this.stateOn = true;
    }

    private boolean switchState() {
        stateOn = !stateOn;
        return stateOn;
    }

    @Override
    public void click() {
        switchState();
        getClickCallback().onClick();
    }

    @Override
    public ClickCallback getClickCallback() {
        return clickCallback;
    }

    @Override
    public String toUISceneView() {
        // TODO: set label according with width; think about height
        String view = (stateOn ? STATE_ON_CHAR : STATE_OFF_CHAR) + " ";
        view += (getWidth() > getName().length() - 2 ? getName() : getName().substring(0, getWidth()));
        return view;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
