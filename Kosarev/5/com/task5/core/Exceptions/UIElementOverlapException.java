package com.task5.core.Exceptions;

import com.task5.core.Elements.UIElement;


public class UIElementOverlapException extends Exception {
    private static final String MSG_PATTERN = "UIElements %s; %s are overlapping";

    public UIElementOverlapException() {
        super(MSG_PATTERN.replace("%s; %s", ""));
    }

    public UIElementOverlapException(UIElement e1, UIElement e2) {
        super(String.format(MSG_PATTERN, e1.toString(), e2.toString()));
    }

    public UIElementOverlapException(String message) {
        super(message);
    }

    public UIElementOverlapException(String message, Throwable cause) {
        super(message, cause);
    }

    public UIElementOverlapException(Throwable cause) {
        super(cause);
    }

    public UIElementOverlapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
