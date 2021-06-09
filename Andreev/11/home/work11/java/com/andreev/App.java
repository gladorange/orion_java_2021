package home.work11.java.com.andreev;

import com.andreev.shop.Shop;

import java.util.Comparator;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Shop shop = new Shop();
        int randomInt = new Random().nextInt(shop.getComparators().size());
        Comparator<ShopItem> comparator = shop.getComparators().get(randomInt);
        shop.getItems().sort(comparator);
        shop.getItems().forEach(System.out::println);
    }
}
