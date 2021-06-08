package com.orion.lesson5.elements;

import com.orion.lesson5.elements.interfaces.ButtonClickCallback;


public class ShowCoordinates implements ButtonClickCallback {

    int coordX;
    int coordY;

    public ShowCoordinates(int x, int y) {
        this.coordX = x;
        this.coordY = y;
    }

    public ShowCoordinates(Object x, Object y) {
    }

    @Override
    public void onButtonClick(){
        System.out.println("Кнопка с координатами " + this.coordX + "/" + this.coordY);
    }
}
