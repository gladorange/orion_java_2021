package com.orion.java.lesson3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Action happyHours = new Action("Счастливые часы", Action.Type.DISCOUNT, 6,23,50);

        Shop firstShop = new Shop("Магазин у дома", 5);
        firstShop.setAction(happyHours);

        Shop secondShop = new Shop("RAPS", 10);
        secondShop.setAction(happyHours);

        Shop thirdShop = new Shop("Pytak", 50);
        thirdShop.setAction(happyHours);

        //make a deal
        //введите товар для покупки
        System.out.println("Ознакомтесь с ассортиментом");
        firstShop.showAssortiment();

        System.out.println("и ведите название выбранного товара: ");
        String itemName = in.nextLine();
        System.out.println("Введите время совершений покупки: ");
        int hour = in.nextInt();

        System.out.println("Наиболее благопрятное время совершения покупки мужду " + firstShop.action.timeStart + " и " + firstShop.action.timeFinish + " часами");
        while(!firstShop.checkItem(itemName)){
            System.out.println("Товар не существует или приобретён. выбериет другой товар");
        }



    }

}
