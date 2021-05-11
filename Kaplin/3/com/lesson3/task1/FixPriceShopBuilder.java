package com.lesson3.task1;

public class FixPriceShopBuilder {
    private String[] items;
    private int happyHour = 23;

    public FixPriceShopBuilder setItems(String[] items) {
        this.items = StorageUtil.validateList(items);
        return this;
    }

    public FixPriceShopBuilder setItems(Contractor contractor) {
        this.items = StorageUtil.validateList(contractor.getItems());
        return this;
    }

    public FixPriceShopBuilder setHappyHour(int happyHour) {
        if(happyHour >= 0 && happyHour < 24) {
            this.happyHour = happyHour;
        } else {
            throw new IllegalArgumentException("happyHour must be between 0 and 23, but happyHour is: " + happyHour);
        }
        return this;
    }

    public FixPriceShop createFixPriceShop() {
        FixPriceShop shop = new FixPriceShop(items, happyHour);
        System.out.println("Создан магазин " + shop.shopName);
        return shop;
    }
}