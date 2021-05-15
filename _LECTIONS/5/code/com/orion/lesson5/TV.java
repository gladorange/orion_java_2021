package com.orion.lesson5;

import java.io.Serializable;
import java.util.Random;

public class TV extends Object implements RadioControllable, Serializable, Stateful {

    boolean isTurnedOn = false;

    void switchCHannel() {
        System.out.println("Переключаю канал");
    }

    @Override
    public void turnOn() {
        if (isTurnedOn) {
            System.out.println("Телевизор уже включен");
            return;
        }

        isTurnedOn = true;
        System.out.println("Телевизор включился");
    }

    @Override
    public void turnOff() {
        if (!isTurnedOn) {
            System.out.println("Телевизор уже выключен");
            return;
        }

        isTurnedOn = false;
        System.out.println("Телевизор выключился");

    }

    @Override
    public boolean isTurnedOn() {
        return isTurnedOn;
    }


    public static class RadioPlaneToy implements RadioControllable, Stateful {

        @Override
        public void turnOn() {
            System.out.println("Лечу вперед пять метров");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Закончил лететь");
        }

        @Override
        public void turnOff() {

        }
    }


    public static void main(String[] args) {
        Stateful tv = new TV();
        // tv.switchChannel(); не работает, т.к переменная типа RadioControllable



        Stateful[] items = new Stateful[10];

        for (int i = 0; i < items.length; i++) {
            if (new Random().nextBoolean()) {
                final TV tv1 = new TV();
                tv1.turnOn();
                items[i] = tv1;
            } else {
                items[i] = new RadioPlaneToy();
            }
        }

        for (Stateful item : items) {
            System.out.println(item.isTurnedOn());
        }



    }
}
