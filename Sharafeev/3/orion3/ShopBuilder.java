package orion3;

import java.util.LinkedList;
import java.util.Random;

public class ShopBuilder {

    public static final int SHOP_DEFAULT_ITEMS_COUNT = 5;
    public static final LinkedList<String> ITEMS_WAREHOUSE;
    static {
        ITEMS_WAREHOUSE = new LinkedList<>() {{
            add("Туалетная бумага");
            add("Антисептик");
            add("Маска");
            add("Салфетки влажные");
            add("Корм для животных");
            add("Зубная паста");
            add("Зубная щетка");
            add("Орешки");
            add("Паленая балтика девятка");
            add("Шоколадка");
            add("Чипсы");
            add("Жевательная резинка");
        }};
    }

    public ShopBuilder() {

    }

    public FixPriceShop createFixShop(int shopId) {
        LinkedList<String> items = new LinkedList<>();
        Random randItem = new Random();
        for (int i = 0; i < SHOP_DEFAULT_ITEMS_COUNT; i++) {
            items.add(ITEMS_WAREHOUSE.get(randItem.nextInt(SHOP_DEFAULT_ITEMS_COUNT - 1) + 1));
        }
        return new FixPriceShop(shopId, items);
    }

    // debug only
    public void printShopInfo(FixPriceShop shop) {
        if(shop == null) {
            System.out.println("Shop passed to printShopInfo is null!");
        }
        System.out.println();
        System.out.println("Shop with index " + shop.getShopId());
        System.out.println("    happyHour = " + shop.getHappyHour());
        System.out.println("    itemsPrice = " + FixPriceShop.ITEMS_PRICE);
        LinkedList<String> items = shop.getItems();
        System.out.println("    items: ");
        if(items != FixPriceShop.EMPTY_LIST) {
            for (String item:
                 items) {
                System.out.println("        " + item);
            }
        } else {
            System.out.println("        shop items list is empty!");
        }
        System.out.println();
    }
}
