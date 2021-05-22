package orion3;

import java.util.LinkedList;
import java.util.Random;

public class FixPriceShop {

    public static final int UPPER_HOUR       = 20;
    public static final int LOW_HOUR         = 8;
    public static final int UPPER_ITEM_PRICE = 150;
    public static final int LOW_ITEM_PRICE   = 10;
    public static final LinkedList<String> EMPTY_LIST = new LinkedList<>();
    public static final int ITEMS_PRICE;
    static {
        ITEMS_PRICE = new Random().nextInt(UPPER_ITEM_PRICE - LOW_ITEM_PRICE) + LOW_ITEM_PRICE;
    }

    private int shopId;
    private int happyHour;
    private LinkedList<String> items;

    public FixPriceShop(int shopId, LinkedList<String> items) {
        Random rand = new Random();
        this.shopId = shopId;
        this.happyHour = rand.nextInt(UPPER_HOUR - LOW_HOUR) + LOW_HOUR;
        this.items = items;
    }

    public int getHappyHour() {
        return happyHour;
    }

    public int getShopId() {
        return shopId;
    }

    public LinkedList<String> getItems() {
        if(items.isEmpty()) {
            return EMPTY_LIST;
        }
        return items;
    }

    int checkItemPrice(String item, int hour) {
        if(!items.contains(item) || hour > UPPER_HOUR || hour < LOW_HOUR)
            return -1;
        if(hour == happyHour) {
            return ITEMS_PRICE;
        } else {
            return ITEMS_PRICE / 2;
        }
    }

    void buyItem(String item, int hour) {
        if(items.contains(item)) {
            System.out.println("    Товар " + item + " продан по цене " + (hour == happyHour ? ITEMS_PRICE : ITEMS_PRICE / 2));
            //System.out.println(" в магазине с индексом " + shopId);
            items.remove(item);
        } else {
            //System.out.println("    Товар " + item + " не найден в магазине с индексом " + shopId);
            System.out.println("    Товар " + item + " не найден в магазине");
        }
    }

}
