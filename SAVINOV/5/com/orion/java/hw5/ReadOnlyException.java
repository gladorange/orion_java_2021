package com.orion.java.hw5;

public class ReadOnlyException extends Exception {
    public ReadOnlyException(Rectangle rectangle) {
        super("Элемент \"" + rectangle.getCaption() + "\" выключен. Нельзя производить действия с выключенным элементом.");
    }
}
