package com.lesson3.task1;

public class Main {
    public static void main(String[] args) {
        Contractor contractor = new Contractor();
        FixPriceShopBuilder builder = new FixPriceShopBuilder();

        FixPriceShop firstShop = builder.setItems(contractor).createFixPriceShop();
        contractor.setSupplyCount(12);
        FixPriceShop secondShop = builder.setItems(contractor).setHappyHour(11).createFixPriceShop();
        FixPriceShop thirdShop = builder.setItems(new String[]{"раб", null, "собака", null, "", ""}).setHappyHour(11).createFixPriceShop();
        // consumer is goes to first shop
        Consumer consumer = new Consumer(firstShop);
        firstShop.showItems();
        // consumer checks best time and bays some item
        consumer.buyItemInShop(firstShop.getItems()[0], consumer.checkBestTime(firstShop.getItems()[0]));
        firstShop.showItems();
        // consumer want buy fake item
        String fakeItem = "ткань";
        consumer.buyItemInShop(fakeItem, consumer.checkBestTime(fakeItem));
        // consumer is goes to second shop, price has gone up
        FixPriceShop.setFixPrice(130);
        consumer.setShop(secondShop);
        secondShop.showItems();
        // consumer checks best time and bays some item
        consumer.buyItemInShop(secondShop.getItems()[1], consumer.checkBestTime(secondShop.getItems()[1]));
        secondShop.showItems();
        // consumer is goes to third shop and discount hs gone up, it's great
        FixPriceShop.setDiscount(0.7);
        consumer.setShop(thirdShop);
        thirdShop.showItems();
        // consumer checks best time and bays some item
        consumer.buyItemInShop(thirdShop.getItems()[0], consumer.checkBestTime(thirdShop.getItems()[0]));
        thirdShop.showItems();
    }
}
