package com.task5.core.Elements;

import com.task5.core.Elements.Templates.ClickCallback;
import com.task5.core.Elements.Templates.Clickable;
import com.task5.core.Elements.Templates.UIElement;
import com.task5.core.Exceptions.UIInvalidSizeException;
import com.task5.core.Exceptions.UIReadOnlyException;

public class CheckBox extends UIElement implements Clickable {
    private static final String TYPE_NAME            = "Checkbox";
    private static final String STATE_ON_CHAR        = "■";
    private static final String STATE_OFF_CHAR       = "□";
    private static final String DISABLED_SQUARE_CHAR = "☒";
    private static final String UL_CORNER_CHAR       = "┌";
    private static final String UR_CORNER_CHAR       = "┐";
    private static final String DL_CORNER_CHAR       = "└";
    private static final String DR_CORNER_CHAR       = "┘";
    private static final String VER_BORDER_CHAR      = "|";
    private static final String HOR_BORDER_CHAR      = "-";
    private static final String SPACE_CHAR           = " ";
    private static final String DISABLED_CHAR        = ":";

    private boolean stateOn;
    private ClickCallback clickCallback;

    private boolean switchState() {
        stateOn = !stateOn;
        return stateOn;
    }

    @Override
    public void click() throws UIReadOnlyException {
        if (isDisabled())
            throw new UIReadOnlyException(this);
        switchState();
        getClickCallback().onClick();
    }

    @Override
    public ClickCallback getClickCallback() {
        return clickCallback;
    }

    @Override
    public void setClickCallback(ClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }

    @Override
    public String toUISceneView() {
        String view = "";
        String square = "";
        String spaceFiller = "";
        if (isDisabled()) {
            square = DISABLED_SQUARE_CHAR;
            spaceFiller = DISABLED_CHAR;
        }
        else if (stateOn) {
            square = STATE_ON_CHAR;
            spaceFiller = SPACE_CHAR;
        }
        else {
            square = STATE_OFF_CHAR;
            spaceFiller = SPACE_CHAR;
        }
        // Upper border
        int typenameStartX = (int) Math.ceil( (getWidth() - getTypeName().length())/2 );
        view += UL_CORNER_CHAR +
                HOR_BORDER_CHAR.repeat(Math.max(typenameStartX - 1, 0)) +
                getTypeName().substring(0, Math.max(Math.min(getWidth()-4, getTypeName().length()), 1)) +
                HOR_BORDER_CHAR.repeat(Math.max(typenameStartX - 1, 0));
        if (view.length() < getWidth() - 1)
            view += HOR_BORDER_CHAR.repeat(getWidth() - 1 - view.length());
        view += UR_CORNER_CHAR + ENDL_CHAR;

        // Body
        int noBordersWidth = getWidth() - 2;
        String viewableText = String.format("%s %s", square, getName())
                .substring(0, Math.min(Math.max(noBordersWidth, 1), getName().length() + 2));
        int textStartX = (int) Math.ceil( (getWidth() - viewableText.length())/2 );
        int textStartY = Math.round(getHeight()/2);
        for (int y = 1; y < getHeight() - 1; y++) {
            if (y == textStartY) {
                String s = VER_BORDER_CHAR + spaceFiller.repeat(Math.max(textStartX - 1, 0)) + viewableText
                        + spaceFiller.repeat(Math.max(textStartX - 1, 0));
                if (s.length() != getWidth() - 1)
                    s += spaceFiller;
                view += s + VER_BORDER_CHAR + ENDL_CHAR;
            } else
                view += VER_BORDER_CHAR + spaceFiller.repeat(noBordersWidth) + VER_BORDER_CHAR + ENDL_CHAR;
        }

        // Bottom body
        view += DL_CORNER_CHAR + HOR_BORDER_CHAR.repeat(noBordersWidth) + DR_CORNER_CHAR + ENDL_CHAR;

        return view;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    public void setStateOn(boolean stateOn) {
        this.stateOn = stateOn;
    }

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

    public CheckBox(int x, int y, int width, int height, String name, boolean disabled, boolean stateOn) throws UIInvalidSizeException {
        super(x, y, width, height, name, disabled);
        this.stateOn = stateOn;
    }

    public CheckBox(int x, int y, int width, int height, String name, boolean stateOn) throws UIInvalidSizeException {
        super(x, y, width, height, name);
        this.stateOn = stateOn;
    }

    @Override
    public String toString() {
        return super.toString() + ". Состояние: " + (stateOn ? "ВКЛ" : "ВЫКЛ");
    }
}
