package com.lesson5.task1.exceptions;

import com.lesson5.task1.abstractions.Element;

public class ElementOverlapException extends Exception {
    public ElementOverlapException( Element oldElement, Element newElement ){
        super(String.format("Элемент %s пересекается с %s, добавление невозможно", newElement.getCaption(), oldElement.getCaption()));
    }
}
