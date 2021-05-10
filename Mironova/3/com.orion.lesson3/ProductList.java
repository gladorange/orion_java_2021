package com.orion.java.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductList {

    private static List<String> productList = new ArrayList(Arrays.asList("Ложка", "Вилка", "Полотенце", "Кастрюоля", "Сковородка", "Крышка", "Дуршлаг", "Тёрка", "Нож", "Крышка", "Блюдце", "Тёрка", "Доска", "Мяч", "Скакалка", "Кукла", "Медведь", "Юла", "Кубики", "Ручка", "Карандаш", "Ножницы", "Альбом", "Фломастеры", "Скотч", "Линейка", "Тетрадь"));

    int productQuantity;
    String[] items;
    Random rand = new Random();

    public ProductList(int productQuantity) {
        int key;
        this.productQuantity = productQuantity;

        if (productQuantity > productList.size()) {

            this.items = productList.toArray(new String[productList.size()]);
            this.productQuantity = productList.size();

        } else {

            this.items = new String[productQuantity];

            for (int i = 0; i < productQuantity; i++) {
                do {
                    key = rand.nextInt(productList.size() - 1);
                }while (Arrays.asList(this.items).contains(productList.get(key)));

                this.items[i] = productList.get(key);
                productList.remove(key);

            }
        }
    }
}
