package com.task5.core.Exceptions;

import com.task5.core.Elements.Templates.UIElement;

public class UIReadOnlyException extends Exception {
    private static final String MSG_PATTERN = "UI instance \"%s\" is disabled and can not being interacted";

    public UIReadOnlyException(UIElement e) {
        super(String.format(MSG_PATTERN, e.getName()));
    }

    public UIReadOnlyException() {
        super("One of " + String.format(MSG_PATTERN, ""));
    }

    public UIReadOnlyException(String message) {
        super(message);
    }

    public UIReadOnlyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UIReadOnlyException(Throwable cause) {
        super(cause);
    }

    public UIReadOnlyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
