package com.lesson5.task1.exceptions;

import com.lesson5.task1.abstractions.Element;

public class ReadOnlyException extends Exception{
    public ReadOnlyException( Element element ){
        super(String.format("Элемент %s, %s выключен", element.getType().toString(), element.getCaption()));
    }
}
