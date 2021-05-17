package com.task5;

import com.task5.core.Elements.Button;
import com.task5.core.Elements.CheckBox;
import com.task5.core.Elements.Templates.Clickable;
import com.task5.core.Elements.Templates.UIElement;
import com.task5.core.Exceptions.UIElementOverlapException;
import com.task5.core.Exceptions.UIInvalidSizeException;
import com.task5.core.Exceptions.UIReadOnlyException;
import com.task5.core.UIScene;

public class Main {
    public static void main(String[] args) throws UIInvalidSizeException, UIElementOverlapException, UIReadOnlyException {
        UIScene testScene = new UIScene(100, 20);
        UIElement ulButton = new Button(1, 1, 14, 6, "UL Button", false, () -> System.out.println("Callback from UL Button"));
        UIElement urButton = new Button(16, 1, 14, 6, "UR Button", false, () -> System.out.println("Callback from UR Button"));
        UIElement dlButton = new Button(1, 7, 14, 6, "Disabled",true, () -> System.out.println("Callback from DL Button"));
        UIElement drButton = new Button(16, 7, 14, 6, "DR Button", false, () -> System.out.println("Callback from DR Button"));
        UIElement checkBox = new CheckBox(5,18,10,1,"TestCheckbox", false, () -> System.out.println("Checkbox callback"), false);
        ((Clickable)checkBox).click();
//        UIElement tooRightButton = new Button(80, 7, 21, 6, "Away from scene", false, () -> System.out.println("asdfas"));
        testScene.addElement(ulButton);
        testScene.addElement(urButton);
        testScene.addElement(dlButton);
        testScene.addElement(drButton);
        testScene.addElement(checkBox);
//        testScene.addElement(tooRightButton);
        testScene.render();
        ((Clickable)ulButton).click();
        ((Clickable)urButton).click();
//        ((Clickable)dlButton).click();
        ((Clickable)drButton).click();
        System.out.println(ulButton.toString());
        System.out.println(checkBox.toString());
//        ((Clickable)tooRightButton).click();
    }
}
