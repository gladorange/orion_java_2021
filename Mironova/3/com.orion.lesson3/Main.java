package com.orion.java.lesson3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Action happyHours = new Action("Счастливые часы", Action.Type.DISCOUNT, 50);

        Shop firstShop = new Shop("Магазин у дома", 5);
        firstShop.setAction(happyHours);
        firstShop.action.setHappyHours(11, 16);

        Shop secondShop = new Shop("RAPS", 10);
        secondShop.setAction(happyHours);
        secondShop.action.setHappyHours(10, 12);

        Shop thirdShop = new Shop("Pytak", 50);
        thirdShop.setAction(happyHours);
        thirdShop.action.setHappyHours(18, 20);

        Deal.makeADeal(firstShop);
        Deal.makeADeal(secondShop);
        Deal.makeADeal(thirdShop);

    }

}
