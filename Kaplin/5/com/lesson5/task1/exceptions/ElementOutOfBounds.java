package com.lesson5.task1.exceptions;

import com.lesson5.task1.abstractions.Element;

public class ElementOutOfBounds extends Exception {
    public ElementOutOfBounds( Element element ){
        super(String.format("Элемент %s выходит за границы дисплея ", element.getCaption())  );
    }
}
