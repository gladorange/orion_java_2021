package com.lesson5;

import com.lesson5.exceptions.ElementOutOfBounds;
import com.lesson5.exceptions.ElementOverlapException;

import java.util.ArrayList;
import java.util.List;

public class UI {
    public static final int MAX_SIZE_X = 100;
    public static final int MAX_SIZE_Y = 100;

    private List<Element> elementList = new ArrayList<>();

    public List<Element> getAllElements(){
        return elementList;
    }

    public void addElement( Element element )  {
        try {
            checkElementBeforeAdd( element.getCoordinateX(), element.getCoordinateY(), element.getWidth(),
                    element.getHeight(), element );
            elementList.add( element );
        } catch ( ElementOverlapException | ElementOutOfBounds e ) {
            e.printStackTrace();
        }
    }

    private void checkElementBeforeAdd( int coordinateX, int coordinateY, int width, int height, Element element )
            throws ElementOverlapException, ElementOutOfBounds {

        if ( coordinateY + height > UI.MAX_SIZE_Y || coordinateX + width > UI.MAX_SIZE_X ) {
            throw new ElementOutOfBounds( element );
        }

        for ( Element e : elementList ) {
            if ( coordinateX + width > e.getCoordinateX()
                    && coordinateY + height > e.getCoordinateY()
                    && coordinateX < e.getCoordinateX() + e.getWidth()
                    && coordinateY < e.getCoordinateY() + e.getHeight() ) {
                throw new ElementOverlapException(element, e);
            }
        }
    }

}
