package com.orion.lesson5.exceptions;

import com.orion.lesson5.elements.Element;

public class ReadOnlyException extends Exception {

    public ReadOnlyException(Element element){
        super(String.format("Элемент %s выключен", element.getCaption()));
    }
}
