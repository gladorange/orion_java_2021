package com.lesson5.elements;

import com.lesson5.Element;

import java.util.Random;
import java.util.stream.Stream;

public class TextField extends Element {
    private String text;


    public TextField( String caption, int coordinateX, int coordinateY, int width, int height ) {
        super( caption, "Текстовое поле", coordinateX, coordinateY, width, height );
        this.text = generateRandomText();
    }


    public String getText() {
        return text;
    }

    public void setText(String text ) {
        this.text = text;
    }

    private String generateRandomText(){
        String alphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();

        Stream.generate(()-> alphaNumericString.charAt( new Random().nextInt( alphaNumericString.length() )))
                .limit( 10 )
                .forEach( stringBuilder::append );
        return stringBuilder.toString();
    }

}
