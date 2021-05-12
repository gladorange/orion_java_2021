package com.orion.lesson3;

public class Main {

    public static void main(String[] args){

        Shop firstShop = new Shop("Магазин у дома", 5);
        firstShop.setAction(new Action("Счастливые часы", Action.Type.DISCOUNT, 50));
        firstShop.setHappyHours(11, 16);

        Shop secondShop = new Shop("RAPS", 10);
        secondShop.setAction(new Action("Счастливые часы", Action.Type.DISCOUNT, 50));
        secondShop.setHappyHours(10, 12);

        Shop thirdShop = new Shop("Pytak", 50);
        thirdShop.setAction(new Action("Счастливые часы", Action.Type.DISCOUNT, 50));
        thirdShop.setHappyHours(18, 20);

        Deal.makeADeal(firstShop);
        Deal.makeADeal(secondShop);
        Deal.makeADeal(thirdShop);

    }

}
