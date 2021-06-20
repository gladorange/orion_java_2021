package com.lesson11.task1;


public class ShopItemSorters {

    public static int sortByPrice(ShopItem prev, ShopItem next) {
        return Double.compare(prev.getPrice(), next.getPrice());
    }

    public static int sortByCategory(ShopItem prev, ShopItem next) {
        return prev.getCategory().compareTo(next.getCategory());
    }

    public static int sortByTitle(ShopItem prev, ShopItem next) {
        return prev.getName().compareTo(next.getName());
    }

    public static int sortByAmount(ShopItem prev, ShopItem next) {
        return Integer.compare(prev.getAmount(), next.getAmount());
    }

}
