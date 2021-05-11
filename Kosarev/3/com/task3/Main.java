package com.task3;


public class Main {

    public static void main(String[] args) {
        int shopSize = 10;
        float discountRatio = 0.5f;
        System.out.println("Создаю магазины:");
        System.out.println("sampleShop1:");
        FixPriceShop sampleShop1 = new FixPriceShopBuilder()
                .setShopSize(shopSize)
                .setLuckyHour( FixPriceShopBuilder.getRandomLuckyHour() )
                .setDiscountRatio(discountRatio)
                .setItems( FixPriceShopBuilder.getRandomItems(shopSize) )
                .createFixPriceShop();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("sampleShop2:");
        FixPriceShop sampleShop2 = new FixPriceShopBuilder()
                .setShopSize(shopSize)
                .setLuckyHour( FixPriceShopBuilder.getRandomLuckyHour() )
                .setDiscountRatio(discountRatio)
                .setItems( FixPriceShopBuilder.getRandomItems(shopSize) )
                .createFixPriceShop();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("sampleShop3:");
        FixPriceShop sampleShop3 = new FixPriceShopBuilder()
                .setShopSize(shopSize)
                .setLuckyHour( FixPriceShopBuilder.getRandomLuckyHour() )
                .setDiscountRatio(discountRatio)
                .setItems( FixPriceShopBuilder.getRandomItems(shopSize) )
                .createFixPriceShop();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("Беру наугад товары из магазинов:");
        String randomItemFromShop1 = sampleShop1.pickRandomItem();
        String randomItemFromShop2 = sampleShop2.pickRandomItem();
        String randomItemFromShop3 = sampleShop3.pickRandomItem();
        System.out.println("Взят товар из sampleShop1: " + randomItemFromShop1);
        System.out.println("Взят товар из sampleShop2: " + randomItemFromShop2);
        System.out.println("Взят товар из sampleShop3: " + randomItemFromShop3);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("Ищу счастливые часы в магазинах:");
        int optHour1 = 0, optHour2 = 0, optHour3 = 0;
        int minPrice1 = sampleShop1.checkItemPrice(randomItemFromShop1, optHour1);
        int minPrice2 = sampleShop2.checkItemPrice(randomItemFromShop2, optHour2);
        int minPrice3 = sampleShop3.checkItemPrice(randomItemFromShop3, optHour3);
        for (int i = 1; i < 23; i++) {
            if (sampleShop1.checkItemPrice(randomItemFromShop1, i) < minPrice1)
                optHour1 = i;

            if (sampleShop2.checkItemPrice(randomItemFromShop2, i) < minPrice2)
                optHour2 = i;

            if (sampleShop3.checkItemPrice(randomItemFromShop3, i) < minPrice3)
                optHour3 = i;
        }

        System.out.println("Счастливый час в sampleShop1: " + optHour1);
        System.out.println("Счастливый час в sampleShop2: " + optHour2);
        System.out.println("Счастливый час в sampleShop3: " + optHour3);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("Покупаю товары в sampleShop1:");
        sampleShop1.buyItem(randomItemFromShop1, optHour1);
        sampleShop1.buyItem(randomItemFromShop1, optHour1);
        System.out.println();

        System.out.println("Покупаю товары в sampleShop2:");
        sampleShop2.buyItem(randomItemFromShop2, optHour2);
        sampleShop2.buyItem(randomItemFromShop2, optHour2);
        System.out.println();

        System.out.println("Покупаю товары в sampleShop3:");
        sampleShop3.buyItem(randomItemFromShop3, optHour3);
        sampleShop3.buyItem(randomItemFromShop3, optHour3);
        System.out.println();

    }
}
