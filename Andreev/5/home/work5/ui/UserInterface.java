package home.work5.ui;

import home.work5.rectangle.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private List<Rectangle> elementsList = new ArrayList<>();

    public List<Rectangle> getAllElements(){
        return elementsList;
    }

    public void addElement(Rectangle rectangle){
        elementsList.add(rectangle);
    }
}
