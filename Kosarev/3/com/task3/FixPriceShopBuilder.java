package com.task3;

import java.util.Random;

public class FixPriceShopBuilder {
    private int shopSize;
    private int luckyHour;
    private float discountRatio = 0.5f;
    private String[] items;
    private static final String[] DEFAULT_ITEM_LIST = new String[]
            {"Хлеб", "Молоко", "Яблоко", "Апельсин", "Масло",
            "Вафли", "Картофель", "Банан", "Сок", "Гречка"};

    public FixPriceShopBuilder setShopSize(int shopSize) {
        this.shopSize = shopSize;
        return this;
    }

    public FixPriceShopBuilder setItems(String[] items) {
        this.items = items;
        return this;
    }

    public FixPriceShopBuilder setLuckyHour(int luckyHour) {
        this.luckyHour = luckyHour;
        return this;
    }

    public FixPriceShopBuilder setDiscountRatio(float discountRatio) {
        this.discountRatio = discountRatio;
        return this;
    }

    public static int getRandomLuckyHour() {
        return new Random().nextInt(23);
    }

    public static String[] getRandomItems(int amount) {
        String[] randomItems = new String[amount];
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            randomItems[i] = DEFAULT_ITEM_LIST[random.nextInt(DEFAULT_ITEM_LIST.length)];
        }
        return randomItems;
    }

    public FixPriceShop createFixPriceShop() {
        return new FixPriceShop(shopSize, luckyHour, discountRatio, items);
    }
}