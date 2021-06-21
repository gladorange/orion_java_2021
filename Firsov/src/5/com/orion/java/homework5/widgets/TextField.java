package com.orion.java.homework5.widgets;


import com.orion.java.homework5.Widget;
import com.orion.java.homework5.exception.ELementsOverlapException;




public class TextField extends Widget {

    String currentText;
    public TextField(int x, int y, int w, int h, boolean isActive, String caption,String currentText) {
        super(x,y,w,h,isActive,caption);
        this.currentText = currentText;
    }

    public String getCurrentText() {
        return currentText;
    }

    public void setText(String newText){
        this.currentText = newText;
        Widget.State.getInstance().update(this);
    }

    public static void main(String[] args) throws ELementsOverlapException {
        TextField textf = new TextField(0,0,5,5,true,"ddg","");
        Widget.UI ui = Widget.UI.getInstance();
        ui.addElement(textf);

        textf.setText("213");
    }
}
