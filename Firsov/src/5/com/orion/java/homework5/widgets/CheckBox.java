package com.orion.java.homework5.widgets;



import com.orion.java.homework5.Clickable;
import com.orion.java.homework5.EventHandler;
import com.orion.java.homework5.Widget;
import com.orion.java.homework5.exception.ELementsOverlapException;
import com.orion.java.homework5.exception.ReadOnlyException;

public class CheckBox extends Widget implements Clickable {
    final static boolean IS_PRESSED_DEFAULT = false;
    private boolean isPressed;
    EventHandler eventHandler;

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
        Widget.State.getInstance().update(this);

    }

    public CheckBox(int x, int y, int w, int h, boolean isActive, String caption, boolean isPressed, EventHandler eventHandler) {
        super(x,y,w,h,isActive,caption);
        this.isPressed = isPressed;
        this.eventHandler = eventHandler;
    }

    @Override
    public void onClick() throws ReadOnlyException {

        if(this.isActive){
            this.eventHandler.execute();
        }else{
            throw new ReadOnlyException("Error:Can't click.The checkBox |"+  this.caption+"| is inactive.");
        }
    }






    public static void main(String[] args) throws ELementsOverlapException {
        CheckBox wgt = new CheckBox(1,2,3,4,true,"chB1",true,new EventHandler() {
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

            }
        };
        /*
        CheckBox wgt = new CheckBox(1,2,3,4,true,"chB1",false,new EventHandler() {
            int currentId = Widget.ID_WIDGET;
            @Override
            public void execute() {
                Widget.State state = Widget.State.getInstance();
                Widget.UI ui = Widget.UI.getInstance();
                CheckBox checkBox =(CheckBox) ui.getAllElements().get(currentId);
                state.update(checkBox);
            }
        }){
            int currentId = Widget.ID_WIDGET-1;
            @Override
            public void update(int updatedWidgetId){
                Widget.UI ui = Widget.UI.getInstance();
                CheckBox checkBox =(CheckBox) ui.getAllElements().get(currentId);
                if(updatedWidgetId ==currentId){
                    if(checkBox.isPressed){
                        checkBox.isPressed = false;
                    }else{
                        checkBox.isPressed = true;
                    }
                }
            }

        };
        */
        Widget.UI ui = Widget.UI.getInstance();
     //   try {
            ui.addElement(wgt);
            System.out.println(wgt.isPressed+" before click");
            try {
                wgt.onClick();
            } catch (ReadOnlyException e) {
                e.printStackTrace();
            }
            System.out.println(wgt.isPressed+" after click");
            /*
            CheckBox wgt1 = new CheckBox(10,2,3,4,true,"chB2",false,new EventHandler() {
                int currentId = Widget.ID_WIDGET;
                @Override
                public void execute() {
                    Widget.State state = Widget.State.getInstance();
                    Widget.UI ui = Widget.UI.getInstance();
                    CheckBox checkBox =(CheckBox) ui.getAllElements().get(currentId);
                    System.out.println("execute "+checkBox.getCaption());

                    state.update(checkBox);
                    // state.update(checkBox);
                }
            }){
                int currentId = Widget.ID_WIDGET-1;
                @Override
                public void update(int updatedWidgetId){
                    System.out.println("update currentId  "+currentId);
                    Widget.UI ui = Widget.UI.getInstance();
                    CheckBox checkBox =(CheckBox) ui.getAllElements().get(currentId);
                    System.out.println("update "+ checkBox.caption);
                    if(updatedWidgetId ==currentId || updatedWidgetId == wgt.id){
                        if(checkBox.isPressed){
                            checkBox.isPressed = false;
                        }else{
                            checkBox.isPressed = true;
                        }
                    }
                }

            };
            ui.addElement(wgt1);
            Widget.State state = Widget.State.getInstance();
            state.addListener(wgt,wgt1);
            System.out.println(wgt.caption+" "+wgt.isPressed+" before click");
            System.out.println(wgt1.caption+" "+wgt1.isPressed+" before click");
            try {
                wgt.onClick();
            } catch (ReadOnlyException e) {
                e.printStackTrace();
            }
            System.out.println(wgt.caption+" "+wgt.isPressed+" after click");
            System.out.println(wgt1.caption+" "+wgt1.isPressed+" after click");

        } catch (ELementsOverlapException e) {
            e.printStackTrace();
        }

         */



    }
}
