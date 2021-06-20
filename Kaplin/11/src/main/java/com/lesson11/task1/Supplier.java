package com.lesson11.task1;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Supplier {

    private final int ID_LENGTH = 25;

    private final double minPrice;
    private final double maxPrice;
    private final int maxItemAmount;


    public Supplier(double minPrice, double maxPrice, int maxItemAmount) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.maxItemAmount = maxItemAmount;
    }


    public List<ShopItem> getRandomShipment(int shipmentSize) {
        Map<String, List<String>> itemStorage = new java.util.HashMap<>(Map.of(
                "Овощи", List.of("Картофель", "Патисоны", "Брокколи", "Томаты", "Кукуруза", "Морковь"),
                "Фрукты", List.of("Черника", "Апельсины", "Лемоны", "Яблоки", "Вишня", "Виноград"),
                "Трава", List.of("Лук", "Петрушка", "Кинза", "Сельдерей", "Канабис", "Базилик")
        ));

        List<ShopItem> shipment = new ArrayList<>();

        for (int i = 0; i < shipmentSize; i++) {
            List<String> categories = new ArrayList<>(itemStorage.keySet());
            if(categories.size() > 0) {
                String category = categories.get(ThreadLocalRandom.current().nextInt(categories.size()));
                List<String> items = itemStorage.get(category);
                String name = items.get(ThreadLocalRandom.current().nextInt(items.size()));
                List<String> clearedItems = items.stream().filter(item -> !item.equals(name)).collect(Collectors.toList());
                itemStorage.put(category, clearedItems);
                String id = generateId();
                double price = ThreadLocalRandom.current().nextDouble(minPrice, maxPrice);
                shipment.add(new ShopItem(id, category, name, price, ThreadLocalRandom.current().nextInt(maxItemAmount)));
                if(itemStorage.get(category).size() == 0) {
                    itemStorage.remove(category);
                }
            } else {
                System.out.println("У поставщика закончились продукты");
            }

        }
        return shipment;
    }

    private String generateId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }
}
