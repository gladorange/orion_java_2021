package com.kosarev;


public class ShopItemSorters {

    public static int sortByCategory(ShopItem i, ShopItem j) {
        return i.getCategory().compareTo(j.getCategory());
    }

    public static int sortByTitle(ShopItem i, ShopItem j) {
        return i.getName().compareTo(j.getName());
    }

    public static int sortByPrice(ShopItem i, ShopItem j) {
        return Double.compare(i.getPrice(), j.getPrice());
    }

    public static int sortByAmount(ShopItem i, ShopItem j) {
        return Integer.compare(i.getAmount(), j.getAmount());
    }

}
