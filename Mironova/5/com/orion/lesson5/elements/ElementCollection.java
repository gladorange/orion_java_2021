package com.orion.lesson5.elements;

import java.util.Map;
import java.util.Random;

//import static com.orion.lesson5.elements.AddElementOnClick.X;

public enum ElementCollection {

    BUTTON {
        @Override
        public Element getElement(Map params) {
            int x = (int) params.get("x");
            int y = (int)params.get("y");
            return new Button(x, y, (int)params.get("weight"), (int)params.get("height"), "Кнопка в <" + x + ", " + y + ">", false, new ShowCoordinates(x,  y));
        }
    },

    CHECK_BOS {
        @Override
        public Element getElement(Map params) {
            return new CheckBox((int)params.get("x"), (int)params.get("y"), (int)params.get("weight"), (int)params.get("height"), "Случайный элемент", new Random().nextBoolean());
        }
    },

    TEXT_FIELD {
        @Override
        public Element getElement(Map params) {
            return new TextField((int)params.get("x"), (int)params.get("y"), (int)params.get("weight"), (int)params.get("height"), "Случайный элемент", false, Integer.toString(new Random().nextInt(10)));
        }
    };

    public abstract Element getElement(Map params);

}
