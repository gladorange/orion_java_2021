package com.lesson3.task1;

import java.net.BindException;
import java.util.Arrays;

public class FixPriceShop {

    private static int fixPrice = 50;
    private static double discount = 0.5;
    private static int shopCount = 0;

    public final String shopName;
    private String[] items;

    public void setHappyHour(int happyHour) {
        if(happyHour < 0 || happyHour > 23) {
            throw new IllegalArgumentException("happyHour must be between 0 and 23, but happyHour is: " + happyHour);
        } else if (happyHour != this.happyHour){
            System.out.println("Счастливые часы в \"" + shopName + "\" поменялись на " + happyHour +  " ч.");
            this.happyHour = happyHour;
        }

    }

    private int happyHour;

    public FixPriceShop(String[] items, int happyHour) {
        shopCount++;
        if(items == null) {
            items = new String[0];
        }
        this.items = items;
        this.happyHour = happyHour;
        shopName =  "магазин " + shopCount;
    }

    public int checkItemPrice(String item, int hour) {
        int price;
        boolean itemInItems = StorageUtil.contains(items, item);
        if(!itemInItems) {
            price = -1;
        } else {
            price = hour == happyHour ? (int) (fixPrice - fixPrice * discount) : fixPrice;
        }
        return price;
    }

    public void buyItem(String item, int hour) {
        int price = checkItemPrice(item, hour);
        if(price == -1) {
            System.out.println("Товар \"" + item +  "\" отсутствует на складе");
        } else {
            items = StorageUtil.filterStorage(items, item);
            System.out.println("Товар \"" + item +  "\" продан по цене " + price);
        }
    }

    public static double getDiscount() {
        return discount;
    }

    public static void setDiscount(double discount) {
        if(discount > 1 || discount < 0) {
            throw new IllegalArgumentException("discount must be between 0 and 1, but discount is: " + discount);
        } else if (discount != FixPriceShop.discount){
            String message = discount < FixPriceShop.discount ? "Скидка уменьшилась" : "Скидка увеличилась";
            System.out.println(message + " , теперь можно съэкономить " + (discount * 100) + "%");
            FixPriceShop.discount = discount;
        }

    }

    public static int getFixPrice() {
        return fixPrice;
    }

    public static void setFixPrice(int fixPrice) {
        if(fixPrice < 0) {
            throw new IllegalArgumentException("price must be > 0, but price is: " + fixPrice);
        } else if (fixPrice != FixPriceShop.fixPrice){
            String message = fixPrice < FixPriceShop.fixPrice ? "Цена уменьшилась" : "Цена увеличилась";
            System.out.println(message + " , теперь все по " + fixPrice);
            FixPriceShop.fixPrice = fixPrice;
        }

    }

    public String[] getItems() {
        return items;
    }

    public void showItems() {
        if(items.length == 0) {

        } else {
            System.out.println("список товаров \"" + shopName + "\":");
            System.out.println(String.join(", ", Arrays.asList(items)));
        }

    }




}
