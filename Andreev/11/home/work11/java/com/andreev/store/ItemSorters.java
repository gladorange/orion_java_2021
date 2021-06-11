package home.work11.java.com.andreev.store;

import com.andreev.shop.ShopItem;

public class ItemSorters {

    public static int sortByCategory(ShopItem item1, ShopItem item2){
        return item1.getCategory().compareTo(item2.getCategory());
    }

    public static int sortByTitle(ShopItem item1, ShopItem item2){
        return item1.getTitle().compareTo(item2.getTitle());
    }

    public static int sortByPrice(ShopItem item1, ShopItem item2) {
        return Double.compare(item1.getPrice(),item2.getPrice());
    }

    public static int sortByQuantity(ShopItem item1, ShopItem item2) {
        return Integer.compare(item1.getQuantity(),item2.getQuantity());
    }
}
