package com.kosarev;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;


public class Shop {
    private static final double MIN_PRICE                       = 10.;
    private static final double MAX_PRICE                       = 1000.;
    private static final int MAX_ITEM_AMOUNT                    = 1000;
    private static final List<Comparator<ShopItem>> COMPARATORS = List.of(
            ShopItemSorters::sortByCategory,
            ShopItemSorters::sortByTitle,
            ShopItemSorters::sortByPrice,
            ShopItemSorters::sortByAmount
    );

    private List<ShopItem> items = new ArrayList<>();


    private String generateId() {
        return RandomStringUtils.randomAlphanumeric(ShopItem.ID_LENGTH);
    }

    public List<ShopItem> getItems() {
        return items;
    }

    public static List<Comparator<ShopItem>> getComparators() {
        return COMPARATORS;
    }

    public void fillRandomItems(int itemAmount) {
        Map<String, List<String>> categoryItemMap = Map.of(
                "Овощи",           List.of("Огурцы", "Кабачки", "Редис", "Перец"),
                "Фрукты",          List.of("Яблоки", "Бананы", "Персики", "Черешня"),
                "Молочное и яйца", List.of("Молоко", "Сыр", "Яйца", "Йогурт"),
                "Мясо",            List.of("Фарш", "Бедро", "Грудка", "Стейк")
        );
        Random r = new Random();

        for (int i = 0; i < itemAmount; i++) {
            List<String> categories = new ArrayList<>(categoryItemMap.keySet());
            String category = categories.get( r.nextInt(categories.size()) );
            List<String> itemsOfCategory = categoryItemMap.get(category);
            String name = itemsOfCategory.get( r.nextInt(itemsOfCategory.size()) );
            String id = generateId();
            double price = r.nextDouble() * (MAX_PRICE - MIN_PRICE) + MIN_PRICE;
            int amount = r.nextInt(MAX_ITEM_AMOUNT);

            items.add(new ShopItem(id, category, name, price, amount));
        }
    }
}