package com.orion.lesson5;

import com.orion.lesson5.elements.Element;
import com.orion.lesson5.exceptions.OutOfRangeException;

import java.util.ArrayList;
import java.util.List;

public class UI {

    public static int MAX_X = 100;
    public static int MAX_Y = 100;
    public static List<Element> elementList = new ArrayList<>();

    public List<Element> getAllElements(){
        return elementList;
    }

    public void addElement(Element element) throws OutOfRangeException {

        if(checkCoords(element)) {
            elementList.add(element);
        }
    }

    private boolean checkCoords(Element element) throws OutOfRangeException {

        for (Element item: elementList){
            if(item.getX() == element.getX() && item.getY() == element.getY()){
                try {
                    throw new OutOfRangeException(element, item);
                }catch (OutOfRangeException e){
                    System.out.println(e.getMessage());
                }

            }
        }

        return true;
    }

}
