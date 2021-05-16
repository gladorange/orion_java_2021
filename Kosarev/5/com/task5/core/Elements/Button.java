package com.task5.core.Elements;

import com.task5.core.Exceptions.UIInvalidSizeException;

public class Button extends UIElement implements Clickable {
    private static final String TYPE_NAME       = "Button";
    private static final String CORNER_CHAR     = "+";
    private static final String HOR_BORDER_CHAR = "-";
    private static final String VER_BORDER_CHAR = "|";
    private static final String SPACE_CHAR      = " ";

    private ClickCallback clickCallback;

    public Button(int x, int y, int width, int height, String name, boolean disabled, ClickCallback clickCallback) throws UIInvalidSizeException {
        super(x, y, width, height, name, disabled);
        this.clickCallback = clickCallback;
    }

    @Override
    public String toUISceneView() {
        // Upper border
        int typenameStartX = (int) Math.floor( (getWidth() - getTypeName().length())/2 );
        String view = CORNER_CHAR + HOR_BORDER_CHAR.repeat(typenameStartX - 1) + getTypeName() + HOR_BORDER_CHAR.repeat(typenameStartX - 1);
        if (view.length() != getWidth() - 1)
            view += HOR_BORDER_CHAR;
        view += CORNER_CHAR + ENDL_CHAR;

        // Body
        int spacesAmount = getWidth() - 2;
        int nameStartX = (int) Math.floor( (getWidth() - getName().length())/2 );
        int nameStartY = Math.round(getHeight()/2);
        for (int y = 1; y < getHeight() - 1; y++) {
            if (y == nameStartY) {
                String s = VER_BORDER_CHAR + SPACE_CHAR.repeat(nameStartX - 1) + getName() + SPACE_CHAR.repeat(nameStartX - 1);
                if (s.length() != getWidth() - 1)
                    s += SPACE_CHAR;
                view += s + VER_BORDER_CHAR + ENDL_CHAR;
            } else
                view += VER_BORDER_CHAR + SPACE_CHAR.repeat(spacesAmount) + VER_BORDER_CHAR + ENDL_CHAR;
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

    @Override
    public String toString() {
        return String.format("Button \"%s\"(x:%d, y:%d, w:%d, h:%d)", getName(), getX(), getY(), getWidth(), getHeight());
    }
}
