package com.lesson3.task1;

import java.util.Arrays;

public class Contractor {
    private String[] storage;
    private int supplyCount = 5;
    private final int MAX_SUPPLY_COUNT = 15;

    public Contractor() {
        fillStorage();
    }
    public String[] getItems() {
        if(supplyCount > storage.length) {
            fillStorage();
        }
        String[] items = Arrays.copyOf(storage, supplyCount);
        storage = StorageUtil.filterStorage(storage, items);
        System.out.println("Поставлено " + items.length + " товаров");
        return items;
    }

    private void fillStorage() {

        storage = new String[] {"мыло","пыль","картофель", "смерть", "ужас",
                "рассада","комбикорм","фотоаппарат", "индульгенция", "танк",
                "нефть","уголь","газ", "цветы", "комар",};
    }

    public void setSupplyCount(int supplyCount) {
        if(supplyCount > MAX_SUPPLY_COUNT || supplyCount < 0) {
            throw new IllegalArgumentException("supplyCount must be between 0 and " + MAX_SUPPLY_COUNT + " , but supplyCount is: " + supplyCount);
        } else if (supplyCount != this.supplyCount) {
            String message = supplyCount < this.supplyCount ? "Поставщик уменьшил поставки" : "Поставщик увеличил поставки";
            System.out.println(message + " , поставляется " + supplyCount + " товаров");
            this.supplyCount = supplyCount;
        }
    }

}
