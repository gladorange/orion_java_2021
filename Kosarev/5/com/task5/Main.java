package com.task5;

import com.task5.core.Elements.Button;
import com.task5.core.Elements.Clickable;
import com.task5.core.Elements.UIElement;
import com.task5.core.Exceptions.UIElementOverlapException;
import com.task5.core.Exceptions.UIInvalidSizeException;
import com.task5.core.UIScene;

public class Main {
    public static void main(String[] args) throws UIInvalidSizeException, UIElementOverlapException {
        UIScene testScene = new UIScene(100, 20);
        UIElement bigButton = new Button(1, 1, 30, 7, "Big Button", false, () -> System.out.println("Callback from bigButton"));
        UIElement smallButton = new Button(25, 6, 15, 4, "Small Button", false, () -> System.out.println("Callback from smallButton"));
        testScene.addElement(bigButton);
        testScene.addElement(smallButton);
        testScene.render();
//        ((Clickable)bigButton).click();
//        ((Clickable)smallButton).click();
    }
}
