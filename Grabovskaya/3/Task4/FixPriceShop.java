package Task4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class FixPriceShop
{
    private static final int NUMBER_HOURS = 24;
    private static final int ITEMS_PRICE = 60;
    private static final int PERCENT_OFF = 50;

    private List<String> items;

    private int happyHour;

    public FixPriceShop(List<String> items, int happyHour)
    {
        this.items = items;
        this.happyHour = happyHour;
    }

    public int checkItemPrice(String item, int hour)
    {
        if (!items.contains(item))
        {
            return -1;
        }

        return happyHour == hour ? (ITEMS_PRICE * PERCENT_OFF / 100) : ITEMS_PRICE;
    }

    public List<String> getItems()
    {
        return items;
    }

    public int numberOfItems()
    {
        return items.size();
    }

    public void buyItem(String item, int hour)
    {
        if (!items.contains(item))
        {
            System.out.println("Товар '" + item + "' не обнаружен");
            return;
        }

        System.out.printf("Товар '%s' продан по цене = %d\n", item, checkItemPrice(item, hour));
        items.remove(item);
    }

    public static void searchHappyHour(FixPriceShop store, String item)
    {
        for (int i = 0; i < NUMBER_HOURS; ++i)
        {
            if (store.checkItemPrice(item, i) < ITEMS_PRICE)
            {
                System.out.println("Оптимальное время для его покупки: " + i);
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        List<String> goods = ReaderGoodsFromFile.readGoodsFromFile();
        if (goods.isEmpty())
        {
            System.out.println("Список товаров пуст!");
            return;
        }

        final int numberStores = 3;
        Random random = new Random();
        List<List<String>> goodsToStores = new ArrayList<>();
        for (int i = 0; i < numberStores; i++)
        {
            goodsToStores.add(new ArrayList<>());
            // Чтобы в каждом магазине точно был хотя бы один товар
            goodsToStores.get(i).add(goods.remove(random.nextInt(goods.size())));
        }

        while (!goods.isEmpty())
        {
            goodsToStores.get(random.nextInt(numberStores)).add(goods.remove(random.nextInt(goods.size())));
        }

        int happyHour = random.nextInt(FixPriceShop.NUMBER_HOURS);
        System.out.println("\"Счастливый час\" 1-го магазина = " + happyHour);
        FixPriceShop firstStore = new FixPriceShop(goodsToStores.get(0), happyHour);
        System.out.println("Товары 1-го магазина: " + firstStore.getItems());
        String randomItem = firstStore.getItems().get(random.nextInt(firstStore.numberOfItems()));
        System.out.println("Случайный товар: " + randomItem);
        // смысл поиска счасливого часа через метод checkItemPrice(...) я так и не поняла...:(
        searchHappyHour(firstStore, randomItem);

        Calendar calendar = new GregorianCalendar();
        int currTime = calendar.get(Calendar.HOUR_OF_DAY);
        firstStore.buyItem(randomItem, currTime); // покупаем товар в текущее время
        firstStore.buyItem(randomItem, currTime);

        happyHour = random.nextInt(FixPriceShop.NUMBER_HOURS);
        System.out.println("\"Счастливый час\" 2-го магазина = " + happyHour);
        FixPriceShop secondStore = new FixPriceShop(goodsToStores.get(1), happyHour);
        System.out.println("Товары 2-го магазина: " + secondStore.getItems());
        randomItem = secondStore.getItems().get(random.nextInt(secondStore.numberOfItems()));
        System.out.println("Случайный товар: " + randomItem);
        searchHappyHour(secondStore, randomItem);

        secondStore.buyItem(randomItem, happyHour); // покупаем товар в "счастливый час"
        secondStore.buyItem(randomItem, happyHour);

        happyHour = random.nextInt(FixPriceShop.NUMBER_HOURS);
        System.out.println("\"Счастливый час\" 3-го магазина = " + happyHour);
        FixPriceShop thirdStore = new FixPriceShop(goodsToStores.get(2), happyHour);
        System.out.println("Товары 3-го магазина: " + thirdStore.getItems());
        randomItem = thirdStore.getItems().get(random.nextInt(thirdStore.numberOfItems()));
        System.out.println("Случайный товар: " + randomItem);
        searchHappyHour(thirdStore, randomItem);

        thirdStore.buyItem(randomItem, 10);
        thirdStore.buyItem(randomItem, 10);
    }
}
