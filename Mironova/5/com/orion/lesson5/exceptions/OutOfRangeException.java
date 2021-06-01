package com.orion.lesson5.exceptions;

import com.orion.lesson5.elements.Element;

public class OutOfRangeException extends Exception {

    public OutOfRangeException(Element newElement, Element existsElement) {
        super(String.format("Элемент %s пересекается с элементом %s . Добавление невозможно!", newElement.getCaption(), existsElement.getCaption()));
    }
}
