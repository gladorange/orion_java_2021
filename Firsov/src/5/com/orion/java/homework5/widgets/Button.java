package com.orion.java.homework5.widgets;

import com.orion.java.homework5.Clickable;
import com.orion.java.homework5.EventHandler;
import com.orion.java.homework5.Widget;
import com.orion.java.homework5.exception.ELementsOverlapException;
import com.orion.java.homework5.exception.ReadOnlyException;

public class Button extends Widget implements Clickable {
    EventHandler eventHandler;
    public Button(int x, int y, int w, int h, boolean isActive, String caption,  EventHandler eventHandler) {
        super(x,y,w,h,isActive,caption);
        this.eventHandler = eventHandler;
    }
    @Override
    public void onClick() throws ReadOnlyException {

        if(this.isActive){
            this.eventHandler.execute();
        }else{
            throw new ReadOnlyException("Error:Can't click.The button |"+  this.caption+"| is inactive.");
        }
        Widget.State.getInstance().update(this);

    }


    public static void main(String[] args) {
        Button btn = new Button(1,2,3,4,true,"btn1",new EventHandler() {
            int currentId = Widget.ID_WIDGET;
            @Override
            public void execute() {
                Widget.UI ui = Widget.UI.getInstance();
                Button button =(Button) ui.getAllElements().get(currentId);
                System.out.println("press "+button.getCaption());
            }
        });
        Widget.UI ui = Widget.UI.getInstance();
        try {
            ui.addElement(btn);
            try {
                btn.onClick();
            } catch (ReadOnlyException e) {
                e.printStackTrace();
            }
        } catch (ELementsOverlapException e) {
            e.printStackTrace();
        }

        Button btn1 = new Button(10,2,3,4,true,"btn1",() -> System.out.println("drgf"));
        try {
            ui.addElement(btn1);
            try {
                btn1.onClick();
            } catch (ReadOnlyException e) {
                e.printStackTrace();
            }
        } catch (ELementsOverlapException e) {
            e.printStackTrace();
        }

    }
}
