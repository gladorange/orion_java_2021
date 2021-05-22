package orion3;

import java.util.LinkedList;

public class TaskMain {

    public static final int SHOPS_COUNT = 3;
    public static final ShopBuilder SHOP_BUILDER = new ShopBuilder();

    public static void main(String[] args) {

        // create shops
        LinkedList<FixPriceShop> shops  = new LinkedList<>();
        for (int i = 0; i < SHOPS_COUNT; i++) {
            shops.add(SHOP_BUILDER.createFixShop(i + 1));
            //SHOP_BUILDER.printShopInfo(shops.getLast());
        }

        // cycle of shops
        int fullPrice = FixPriceShop.ITEMS_PRICE;
        for (FixPriceShop shop:
             shops) {
            System.out.println("FixPriceShop with index " + shop.getShopId());
            // cycle until FixPriceShop returns empty items list
            LinkedList<String> shopItems = shop.getItems();
            int happyHour = 0;
            while (shopItems != FixPriceShop.EMPTY_LIST) {
                // take item, find happyHour (first time), buy it
                String item = shopItems.getLast();
                if(happyHour == 0) {
                    for (int i = FixPriceShop.LOW_HOUR; i < FixPriceShop.UPPER_HOUR; i++) {
                        if(shop.checkItemPrice(item, i) != fullPrice) {
                            happyHour = i;
                            break;
                        }
                    }
                }
                // buy item until it exists in shop
                do {
                    shop.buyItem(item, happyHour);
                } while (shop.checkItemPrice(item, happyHour) != -1);
                // for task only
                shop.buyItem(item, happyHour);
                shopItems = shop.getItems();
            }
        }

    }

}
