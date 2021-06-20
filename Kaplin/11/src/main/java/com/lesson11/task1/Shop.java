package com.lesson11.task1;

import java.util.*;



public class Shop {

    private static final List<Comparator<ShopItem>> COMPARATORS = List.of(
            ShopItemSorters::sortByCategory,
            ShopItemSorters::sortByTitle,
            ShopItemSorters::sortByPrice,
            ShopItemSorters::sortByAmount
    );

    private List<ShopItem> items = new ArrayList<>();


    public Shop(List<ShopItem> items) {
        this.items = items;
    }

    public Shop() {
    }

    public List<ShopItem> getItems() {
        return items;
    }

    public static List<Comparator<ShopItem>> getComparators() {
        return COMPARATORS;
    }

    public void getDelivery(List<ShopItem> items) {
        this.items = items;
    }


}