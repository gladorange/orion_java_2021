package com.lesson5.task1.elements;

import com.lesson5.task1.abstractions.Element;
import com.lesson5.task1.abstractions.ElementType;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class TextField extends Element {
    private String text;


    public TextField( String caption, int xCoord, int yCoord, int width, int height ) {
        super( caption, ElementType.TEXT_FIELD, xCoord, yCoord, width, height );
        this.text = generateRandomText();
    }


    public String getText() {
        return text;
    }

    public void setText(String text ) {
        this.text = text;
    }

    private String generateRandomText(){
        return UUID.randomUUID().toString();
    }

}
