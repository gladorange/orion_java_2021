package com.lesson5.task1;

import com.lesson5.task1.abstractions.Element;
import com.lesson5.task1.exceptions.ElementOutOfBounds;
import com.lesson5.task1.exceptions.ElementOverlapException;

import java.util.ArrayList;
import java.util.List;

public class UI {
    private final int xMax;
    private final int yMax;

    private List<Element> elementList = new ArrayList<>();

    public UI(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public List<Element> getAllElements() {
        return elementList;
    }

    public void addElement(Element element) {
        try {
            checkElementBeforeAdd(element.getXCoord(), element.getYCoord(), element.getWidth(),
                    element.getHeight(), element);
            elementList.add(element);
        } catch (ElementOverlapException | ElementOutOfBounds e) {
            e.printStackTrace();
        }
    }

    private void checkElementBeforeAdd(int xCoord, int yCoord, int width, int height, Element element)
            throws ElementOverlapException, ElementOutOfBounds {

        if (yCoord + height > yMax || xCoord + width > xMax) {
            throw new ElementOutOfBounds(element);
        }

        for (Element e : elementList) {
            if (xCoord + width > e.getXCoord()
                    && yCoord + height > e.getYCoord()
                    && xCoord < e.getXCoord() + e.getWidth()
                    && yCoord < e.getYCoord() + e.getHeight()) {
                throw new ElementOverlapException(element, e);
            }
        }
    }

    public int getXMax() {
        return xMax;
    }

    public int getYMax() {
        return yMax;
    }
}
