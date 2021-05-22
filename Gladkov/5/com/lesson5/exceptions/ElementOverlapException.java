package com.lesson5.exceptions;

import com.lesson5.Element;

public class ElementOverlapException extends Exception {
    public ElementOverlapException( Element oldElement, Element newElement ){
        super( "Элемент "+ "\""+oldElement.getCaption() +"\"" + " не может быть добавлен т.к пересекается c " + "\""
                + newElement.getCaption() +"\"" );
    }
}
