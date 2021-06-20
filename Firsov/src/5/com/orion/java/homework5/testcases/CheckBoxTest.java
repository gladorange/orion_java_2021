package com.orion.java.homework5.testcases;

import com.orion.java.homework5.EventHandler;
import com.orion.java.homework5.Widget;
import com.orion.java.homework5.exception.ELementsOverlapException;
import com.orion.java.homework5.exception.ReadOnlyException;
import com.orion.java.homework5.widgets.Button;
import com.orion.java.homework5.widgets.CheckBox;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckBoxTest {
    @Test
    /**
     *  Тестирования возможности подписки на обновление виджета.
     *  По нажатию на кнопку происхожит изменение состояние двух chekBox на противоположное.
     */
    public void testCheckBoxObservers() {
        Button addButton =new Button(0,0,5,5,true,"Btn",() -> System.out.println("Press btn"));
        CheckBox checkBox1 = new CheckBox(1,10,3,4,true,"chB1",true,new EventHandler() {
            int currentId = Widget.ID_WIDGET;
            @Override
            public void execute() {
                Widget.State state = Widget.State.getInstance();
                Widget.UI ui = Widget.UI.getInstance();
                CheckBox checkBox =(CheckBox) ui.getAllElements().get(currentId);
                boolean isPressed = checkBox.isPressed();
                if(checkBox.isPressed()){
                    checkBox.setPressed(false);
                }else{
                    checkBox.setPressed(true);
                }
            }
        }){
            int currentId = Widget.ID_WIDGET-1;
            @Override
            public void update(Widget updatedWidget){
                if(Widget.State.getInstance().isWidgetsEguals(updatedWidget,addButton)){

                    if(this.isPressed()){
                        this.setPressed(false);
                    }else{
                        this.setPressed(true);
                    }
                }
            }
        };
        boolean checkBox1State = checkBox1.isPressed();
        CheckBox checkBox2 = new CheckBox(6,0,3,4,true,"chB2",false,new EventHandler() {
            int currentId = Widget.ID_WIDGET;
            @Override
            public void execute() {
                Widget.State state = Widget.State.getInstance();
                Widget.UI ui = Widget.UI.getInstance();
                CheckBox checkBox =(CheckBox) ui.getAllElements().get(currentId);
                boolean isPressed = checkBox.isPressed();
                if(checkBox.isPressed()){
                    checkBox.setPressed(false);
                }else{
                    checkBox.setPressed(true);
                }
            }
        }){
            int currentId = Widget.ID_WIDGET-1;
            @Override
            public void update(Widget updatedWidget){
                if(Widget.State.getInstance().isWidgetsEguals(updatedWidget,addButton)){

                    if(this.isPressed()){
                        this.setPressed(false);
                    }else{
                        this.setPressed(true);
                    }
                }
            }
        };
        boolean checkBox2State = checkBox2.isPressed();
        try {
            Widget.UI ui =   Widget.UI.getInstance() ;
            ui.addElement(addButton);
            ui.addElement(checkBox1);
            ui.addElement(checkBox2);
            Widget.State state = Widget.State.getInstance();
            state.addListener(addButton,checkBox1);
            state.addListener(addButton,checkBox2);

            assertEquals(checkBox1State,!checkBox2State);
            try {
                addButton.onClick();
                assertEquals(!checkBox1State, checkBox1.isPressed());
                assertEquals(!checkBox2State, checkBox2.isPressed());
            } catch (ReadOnlyException e) {
                e.printStackTrace();
            }

        } catch (ELementsOverlapException e) {
            e.printStackTrace();
        }


    }
}
