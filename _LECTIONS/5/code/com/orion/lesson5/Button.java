package com.orion.lesson5;

import java.util.Random;

public class Button {

    String name;
    ButtonClickListener callback;

    public Button(String name, ButtonClickListener callback) {
        this.name = name;
        this.callback = callback;
    }

    interface ButtonClickListener {
        void onButtonClick();


        default int getRandomNumber() {
            return new Random().nextInt(6);
        }
    }

    void click() {
        callback.onButtonClick();
    }


    static class ButtonC1lickListener implements ButtonClickListener {

        @Override
        public void onButtonClick() {
            System.out.println("Нажали кнопку Hello");
        }
    }

    public static void main(String[] args) {
        Button b1 = new Button("Hello", new ButtonC1lickListener());

        b1.click();
        b1.click();
        b1.click();


        Button b2 = new Button("Считаем до 10", new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }

            @Override
            public boolean equals(Object obj) {
                //
                return super.equals(obj);
            }
        });

        b2.click();

        //Button b3 = new Button("Случайное число", () -> System.out.println(text));
      //  b3.click();
    }
}
