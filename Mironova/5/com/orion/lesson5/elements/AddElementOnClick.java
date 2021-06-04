package com.orion.lesson5.elements;

import com.orion.lesson5.UI;
import com.orion.lesson5.elements.interfaces.ButtonClickCallback;
import com.orion.lesson5.exceptions.OutOfRangeException;
import java.util.*;

public class AddElementOnClick implements ButtonClickCallback {
    //public static final String X = "x";

    UI scene;
    Random rand = new Random();

    public AddElementOnClick(UI scene) {
        this.scene = scene;
    }

    @Override
    public void onButtonClick() throws OutOfRangeException {
        Element toAdd = generateRandomElement();
        scene.addElement(toAdd);

    }

    private Element generateRandomElement() {

        Map<String, Integer> paramsList = generateRandomParams();
        ElementCollection[] elementList = ElementCollection.values();
        return elementList[rand.nextInt(elementList.length)].getElement(paramsList);
    }

    private Map<String, Integer> generateRandomParams(){

        Map <String, Integer> paramsList = new HashMap<String, Integer>();

        paramsList.put("x", rand.nextInt(scene.MAX_X));
        paramsList.put("y", rand.nextInt(scene.MAX_Y));
        paramsList.put("weight", rand.nextInt(Element.MAX_WEIGHT));
        paramsList.put("height", rand.nextInt(Element.MAX_HEIGHT));

        return paramsList;


    }
}
