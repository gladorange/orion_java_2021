package com.orion.java.homework5;





import com.orion.java.homework5.exception.ELementsOverlapException;
import com.orion.java.homework5.exception.ReadOnlyException;
import com.orion.java.homework5.widgets.Button;
import com.orion.java.homework5.widgets.CheckBox;
import com.orion.java.homework5.widgets.TextField;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    final static int GENERATED_WIDGET_NUMBER = 10;
    public static void main(String[] args) {
        Widget.UI ui = Widget.UI.getInstance();

        TextField textFieldX = new TextField( 0, 50, 10, 6, true,"Координата x для нового элемента","0" );
        TextField textFieldY = new TextField(0, 80, 10, 6, true,"Координата y для нового элемента","0" );
        Button addButton = new Button(0,0, 30, 10, true,"Добавить элемент", new EventHandler() {
            @Override
            public void execute() {
                int coordinateX = Integer.valueOf(textFieldX.getCurrentText());
                int coordinateY = Integer.valueOf(textFieldX.getCurrentText());
                Widget widget = RandomWidgetGeneratorClass.generateRandomElement(coordinateX,coordinateY);
                try {
                    Widget.UI.getInstance().addElement(widget);
                } catch (ELementsOverlapException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            ui.addElement(addButton);
            ui.addElement(textFieldX);
            ui.addElement(textFieldY);
            for (int i = 0; i < GENERATED_WIDGET_NUMBER; i++) {
                textFieldX.setText(String.valueOf(new Random().nextInt(Widget.UI.NUM_CELLS)));
                textFieldY.setText(String.valueOf(new Random().nextInt(Widget.UI.NUM_CELLS)));
                try {
                    addButton.onClick();
                } catch (ReadOnlyException e) {
                    e.printStackTrace();
                }
            }
        } catch (ELementsOverlapException e) {
            e.printStackTrace();
        }  catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        HashMap<Integer, Widget>  allWidget = ui.getAllElements();
        System.out.println("----All elements ---- ");
        for (Map.Entry  entr: allWidget.entrySet()) {
           Widget wgt = allWidget.get(entr.getKey());
            System.out.println(wgt.getClass().getSimpleName() + " в координатах "
                    + wgt.getX() + "," + wgt.getY() + ", ширина " + wgt.getW()
                    + ", высота " + wgt.getH() + ", Название: " + wgt.getCaption() );

            if ( wgt instanceof  Button || wgt instanceof CheckBox) {
                System.out.println("Try to click ... ");
                if (wgt instanceof CheckBox) {
                    System.out.println("Состояние галки до клика: " + ((CheckBox) wgt).isPressed() );
                }
                try {
                    ((Clickable) wgt).onClick();
                } catch (ReadOnlyException e) {
                    e.printStackTrace();
                }


                if (wgt instanceof CheckBox) {
                    System.out.println("Состояние галки после клика: " + ((CheckBox) wgt).isPressed() );
                }
            } else if(wgt instanceof TextField){

                System.out.println("Текстовое поле содержит следующий текст: " +   ((TextField) wgt).getCurrentText()  );
            }
        }






    }
}
