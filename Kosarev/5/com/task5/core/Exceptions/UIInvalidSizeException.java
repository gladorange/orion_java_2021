package com.task5.core.Exceptions;


public class UIInvalidSizeException extends Exception {
    private static final String MSG_PATTERN = "UI instance has invalid size (%d;%d)";

    public UIInvalidSizeException() {
        super(MSG_PATTERN.replace("(%d;%d)", ""));
    }

    public UIInvalidSizeException(int width, int height) {
        super(String.format(MSG_PATTERN, width, height));
    }

    public UIInvalidSizeException(String message) {
        super(message);
    }

    public UIInvalidSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UIInvalidSizeException(Throwable cause) {
        super(cause);
    }

    public UIInvalidSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
