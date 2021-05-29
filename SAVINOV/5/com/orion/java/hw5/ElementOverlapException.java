package com.orion.java.hw5;

public class ElementOverlapException extends Exception {
    public ElementOverlapException(Rectangle newElement, Rectangle oldElement) {
        super("Элемент " + "\"" + newElement.getCaption() + "\"" + " не может быть добавлен т.к пересекается c " + "\""
                + oldElement.getCaption() + "\"");
    }
}
