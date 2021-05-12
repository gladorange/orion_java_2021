package com.task3;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;


public class FixPriceShop {

    public static final int ITEM_PRICE = 49;
    private final int shopSize;
    private final int luckyHour;
    private float discountRatio;
    private String[] items;

    public FixPriceShop(int shopSize, int luckyHour, float discountRatio, String[] items) {
        if (shopSize <= 0)
            throw new IllegalArgumentException("shopSize = " + shopSize + " can not be less than/equal to zero");
        if (luckyHour < 0 || luckyHour > 23)
            throw new IllegalArgumentException("luckyHour = " + luckyHour + " must be in range [0; 23]");
        if (discountRatio <= 0 || discountRatio >= 1)
            throw new IllegalArgumentException("discountRatio = " + discountRatio + " must be in range (0; 1)");
        if (items.length > shopSize)
            throw new IllegalArgumentException("Passed too much items (" + items.length + ") for shop with size = " + shopSize);

        this.shopSize = shopSize;
        this.luckyHour = luckyHour;
        this.discountRatio = discountRatio;
        this.items = new String[shopSize];
        for (int i = 0; i < items.length; i++)
            this.items[i] = items[i];
        System.out.printf("Создан магазин (shopSize: %d; luckyHour: %d; discountRatio: %f)\n", shopSize, luckyHour, discountRatio);
        printItems();
    }

    public int checkItemPrice(String item, int hour) {
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("hour = " + hour + " must be in range [0; 23]");
        if (Arrays.stream(items).noneMatch(x -> x == item))
            return -1;

        int price = ITEM_PRICE;
        if (hour == luckyHour)
            price = Math.round(ITEM_PRICE * discountRatio);
        return price;
    }

    public String[] getItems() {
        return Arrays.stream(items).filter(Objects::nonNull).toArray(String[]::new);
    }

    public void buyItem(String item, int hour) {
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("hour = " + hour + " must be in range [0; 23]");
        if (Arrays.stream(items).noneMatch(x -> x == item))
            System.out.printf("Товар \"%s\" не обнаружен\n", item);
        else {
            System.out.printf("Товар \"%s\" продан по цене %d\n", item, checkItemPrice(item, hour));
            items[Arrays.asList(items).indexOf(item)] = null;
        }

    }

    public void printItems() {
        System.out.print("[ ");
        Arrays.stream(items)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> System.out.printf("%s(%d) ", k, v.size()));
        System.out.println("]");
    }

    public String pickRandomItem() {
        String[] items = getItems();
        return items[new Random().nextInt(items.length)];
    }

}
