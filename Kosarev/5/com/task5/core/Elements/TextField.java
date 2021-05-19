package com.task5.core.Elements;

import com.task5.core.Elements.Templates.UIElement;
import com.task5.core.Exceptions.UIInvalidSizeException;

import java.util.Arrays;

public class TextField extends UIElement {
    private static final String TYPE_NAME       = "TextField";
    private static final String UL_CORNER_CHAR  = "┌";
    private static final String UR_CORNER_CHAR  = "┐";
    private static final String DL_CORNER_CHAR  = "└";
    private static final String DR_CORNER_CHAR  = "┘";
    private static final String VER_BORDER_CHAR = "|";
    private static final String HOR_BORDER_CHAR = "-";
    private static final String SPACE_CHAR      = " ";
    private static final String DISABLED_CHAR   = ":";

    private String content;

    public TextField(int x, int y, int width, int height, String name, boolean disabled, String content) throws UIInvalidSizeException {
        super(x, y, width, height, name, disabled);
        this.content = content;
    }

    public TextField(int x, int y, int width, int height, String name, String content) throws UIInvalidSizeException {
        super(x, y, width, height, name);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toUISceneView() {
        String spaceFiller = isDisabled() ? DISABLED_CHAR : SPACE_CHAR;
        String view = "";
        // Upper border
        int typenameStartX = (int) Math.ceil( (getWidth() - getTypeName().length() - getName().length())/2 );
        view += UL_CORNER_CHAR +
                HOR_BORDER_CHAR.repeat(Math.max(typenameStartX - 1, 0)) +
                getName().substring(0, Math.min(getWidth()-4, getName().length())) +
                HOR_BORDER_CHAR.repeat(Math.max(typenameStartX - 1, 0));
        if (view.length() < getWidth() - 1)
            view += HOR_BORDER_CHAR.repeat(getWidth() - 1 - view.length());
        view += UR_CORNER_CHAR + ENDL_CHAR;

        // Body
        int noBordersWidth = getWidth() - 2;
        String[] viewableContent = Arrays.stream(content.split("\n"))
                .map(s -> {
                    int spacesAmount = Math.max(noBordersWidth, 1) - s.length();
                    if (spacesAmount > 0)
                        return s + spaceFiller.repeat(spacesAmount);
                    else
                        return s;
                } )
                .map(s -> s.substring(0, Math.max(noBordersWidth, 1)))
                .toArray(String[]::new);

        int contentStartX = (int) Math.ceil( (getWidth() - viewableContent[0].length())/2 );
        int contentStartY = Math.round(getHeight()/2);
        int contentEndY = contentStartY + Math.min(viewableContent.length, getHeight());
        for (int y = 1; y < getHeight() - 1; y++) {
            if (y >= contentStartY && y < contentEndY) {
                String s = VER_BORDER_CHAR + spaceFiller.repeat(Math.max(contentStartX - 1, 0))
                        + viewableContent[y - contentStartY] + spaceFiller.repeat(Math.max(contentStartX - 1, 0));
                if (s.length() != getWidth() - 1)
                    s += spaceFiller;
                view += s + VER_BORDER_CHAR + ENDL_CHAR;
            } else
                view += VER_BORDER_CHAR + spaceFiller.repeat(noBordersWidth) + VER_BORDER_CHAR + ENDL_CHAR;
        }

        // Bottom border
        view += DL_CORNER_CHAR + HOR_BORDER_CHAR.repeat(noBordersWidth) + DR_CORNER_CHAR + ENDL_CHAR;

        return view;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
