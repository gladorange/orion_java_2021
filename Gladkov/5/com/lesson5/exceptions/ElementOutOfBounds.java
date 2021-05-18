package com.lesson5.exceptions;

import com.lesson5.Element;

public class ElementOutOfBounds extends Exception {
    public ElementOutOfBounds( Element element ){
        super( "Элемент выходит за границы интерфейса! " + element );
    }
}
