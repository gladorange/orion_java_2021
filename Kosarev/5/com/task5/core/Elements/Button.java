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

    @Override
    public void click() throws UIReadOnlyException {
        if (isDisabled())
            throw new UIReadOnlyException(this);
    }

    @Override
    public String toUISceneView() {
        String spaceFiller = isDisabled() ? DISABLED_CHAR : SPACE_CHAR;
        // Upper border
        int typenameStartX = (int) Math.ceil( (getWidth() - getTypeName().length())/2 );
        String view = CORNER_CHAR + HOR_BORDER_CHAR.repeat(typenameStartX - 1) + getTypeName() + HOR_BORDER_CHAR.repeat(typenameStartX - 1);
        if (view.length() != getWidth() - 1)
            view += HOR_BORDER_CHAR;
        view += CORNER_CHAR + ENDL_CHAR;

        // Body
        int spacesAmount = getWidth() - 2;
        int nameStartX = (int) Math.ceil( (getWidth() - getName().length())/2 );
        int nameStartY = Math.round(getHeight()/2);
        for (int y = 1; y < getHeight() - 1; y++) {
            if (y == nameStartY) {
                String s = VER_BORDER_CHAR + spaceFiller.repeat(Math.max(nameStartX - 1, 0)) + getName() + spaceFiller.repeat(Math.max(nameStartX - 1, 0));
                if (s.length() != getWidth() - 1)
                    s += spaceFiller;
                view += s + VER_BORDER_CHAR + ENDL_CHAR;
            } else
                view += VER_BORDER_CHAR + spaceFiller.repeat(spacesAmount) + VER_BORDER_CHAR + ENDL_CHAR;
        }

        // Bottom border
        view += CORNER_CHAR + HOR_BORDER_CHAR.repeat(spacesAmount) + CORNER_CHAR + ENDL_CHAR;
        return view;
    }

    @Override
    public ClickCallback getClickCallback() {
        return clickCallback;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

}
