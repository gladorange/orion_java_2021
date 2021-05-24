package com.lesson5.exceptions;

import com.lesson5.Element;

public class ReadOnlyException extends Exception{
    public ReadOnlyException( Element element ){
        super( "Данный элемент выключен " + element.getType()+" " + element.getCaption() );
    }
}
