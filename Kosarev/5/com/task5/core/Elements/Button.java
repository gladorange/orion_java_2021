package com.task5.core.Elements;

import com.task5.core.Elements.Templates.ClickCallback;
import com.task5.core.Elements.Templates.Clickable;
import com.task5.core.Elements.Templates.UIElement;
import com.task5.core.Exceptions.UIInvalidSizeException;
import com.task5.core.Exceptions.UIReadOnlyException;

public class Button extends UIElement implements Clickable {
    private static final String TYPE_NAME       = "Button";
    private static final String CORNER_CHAR     = "+";
    private static final String HOR_BORDER_CHAR = "-";
    private static final String VER_BORDER_CHAR = "|";
    private static final String SPACE_CHAR      = " ";
    private static final String DISABLED_CHAR   = ":";

    private ClickCallback clickCallback;

    public Button(int x, int y, int width, int height, String name, boolean disabled, ClickCallback clickCallback) throws UIInvalidSizeException {
        super(x, y, width, height, name, disabled);
        this.clickCallback = clickCallback;
    }

    public Button(int x, int y, int width, int height, String name, ClickCallback clickCallback) throws UIInvalidSizeException {
        super(x, y, width, height, name);
        this.clickCallback = clickCallback;
    }

    public Button(int x, int y, int width, int height, String name) throws UIInvalidSizeException {
        super(x, y, width, height, name);
    }

    @Override
    public void click() throws UIReadOnlyException {
        if (isDisabled())
            throw new UIReadOnlyException(this);
        clickCallback.onClick();
    }

    @Override
    public String toUISceneView() {
        String spaceFiller = isDisabled() ? DISABLED_CHAR : SPACE_CHAR;
        String view = "";
        // Upper border
        int typenameStartX = (int) Math.ceil( (getWidth() - getTypeName().length())/2 );
        view += CORNER_CHAR +
                HOR_BORDER_CHAR.repeat( Math.max(typenameStartX - 1, 0) ) +
                getTypeName().substring(0, Math.max(Math.min(getWidth()-4, getTypeName().length()), 1)) +
                HOR_BORDER_CHAR.repeat( Math.max(typenameStartX - 1, 0) );
        if (view.length() < getWidth() - 1)
            view += HOR_BORDER_CHAR.repeat(getWidth() - 1 - view.length());
        view += CORNER_CHAR + ENDL_CHAR;

        // Body
        int noBordersWidth = getWidth() - 2;
        String viewableName = getName().substring(0, Math.min(Math.max(noBordersWidth, 1), getName().length()));
        int nameStartX = (int) Math.ceil( (getWidth() - getName().length())/2 );
        int nameStartY = Math.round(getHeight()/2);
        for (int y = 1; y < getHeight() - 1; y++) {
            if (y == nameStartY) {
                String s = VER_BORDER_CHAR + spaceFiller.repeat(Math.max(nameStartX - 1, 0)) +viewableName + spaceFiller.repeat(Math.max(nameStartX - 1, 0));
                if (s.length() != getWidth() - 1)
                    s += spaceFiller;
                view += s + VER_BORDER_CHAR + ENDL_CHAR;
            } else
                view += VER_BORDER_CHAR + spaceFiller.repeat(noBordersWidth) + VER_BORDER_CHAR + ENDL_CHAR;
        }

        // Bottom border
        view += CORNER_CHAR + HOR_BORDER_CHAR.repeat(noBordersWidth) + CORNER_CHAR + ENDL_CHAR;
        return view;
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
    public String getTypeName() {
        return TYPE_NAME;
    }

}
