package com.orion.java.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        int luckyHour = 0;

        System.out.println("**************clothingStore****************");
        FixPriceShop clothingStore = new FixPriceShop(new String[]{"майка", null, "джинсы", "", "кепка"});
        for (String str : clothingStore.getItems()) {
            System.out.println(str);
        }

        for (luckyHour = 0; luckyHour < 24; luckyHour++) {
            if (clothingStore.checkItemPrice("кепка", luckyHour) < FixPriceShop.PRICE) {
                break;
            }
        }
        System.out.println("Счастливый час " + luckyHour);
        clothingStore.buyItem("кепка", luckyHour);
        clothingStore.buyItem("майка", luckyHour);
        clothingStore.buyItem("кепка", luckyHour);

        System.out.println("*************electronicsStore*****************");
        FixPriceShop electronicsStore = new FixPriceShop(new String[]{"телевизор", null, "миксер", "блендер", "микроволновка"});
        for (String str : electronicsStore.getItems()) {
            System.out.println(str);
        }
        for (luckyHour = 0; luckyHour < 24; luckyHour++) {
            if (electronicsStore.checkItemPrice("блендер", luckyHour) < FixPriceShop.PRICE) {
                break;
            }
        }
        System.out.println("Счастливый час " + luckyHour);
        electronicsStore.buyItem("телевизор", luckyHour);
        electronicsStore.buyItem("телевизор", luckyHour);

        System.out.println("*************productsStore*****************");
        FixPriceShop productsStore = new FixPriceShop(new String[]{"колбаса", "соль", "молоко", "", "хлеб"});
        for (String str : productsStore.getItems()) {
            System.out.println(str);
        }
        for (luckyHour = 0; luckyHour < 24; luckyHour++) {
            if (productsStore.checkItemPrice("соль", luckyHour) < FixPriceShop.PRICE) {
                break;
            }
        }
        System.out.println("Счастливый час " + luckyHour);
        productsStore.buyItem("молоко", luckyHour);
        productsStore.buyItem("молоко", luckyHour);
    }
}

class FixPriceShop {
    public static final double PRICE = 49.0;
    private final double DISCOUNT = 0.51;
    private final int happyHour;
    private String[] items;

    FixPriceShop(String[] items) {
        this.items = items;
        happyHour = randomInt(24);
    }

    public int checkItemPrice(String item, int hour) {
        String[] arr = returnWithoutNullOrEmptyItems(items);

        if (getIndexItemInArray(arr, item) < 0)
            return -1;

        if (happyHour == hour)
            return (int) (PRICE * DISCOUNT);
        else
            return (int) PRICE;
    }

    public String[] getItems() {
        return returnWithoutNullOrEmptyItems(items);
    }

    public void buyItem(String item, int hour) {
        int index = getIndexItemInArray(items, item);
        if (index < 0)
            System.out.printf("товар '%s' не обнаружен\n", item);
        else {
            System.out.printf("товар %s продан по цене %d\n", item, checkItemPrice(item, hour));
        }
        items = returnWithoutItemInArray(index);
    }

    private int randomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    private String[] returnWithoutNullOrEmptyItems(String[] arr) {
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            if (str != null && str.length() > 0)
                list.add(str);
        }
        return list.toArray(new String[0]);
    }

    private int getIndexItemInArray(String[] arr, String item) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].length() != 0 && arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private String[] returnWithoutItemInArray(int index) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (i != index)
                list.add(items[i]);
        }
        return list.toArray(new String[0]);
    }
}