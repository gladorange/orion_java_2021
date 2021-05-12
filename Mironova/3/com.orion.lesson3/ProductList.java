package com.orion.lesson3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductList {

    private static List<String> productList = new ArrayList(Arrays.asList("ложка", "вилка", "полотенце", "кастрюоля",
            "сковородка", "крышка", "дуршлаг", "тёрка", "нож", "крышка", "блюдце", "доска", "мяч",
            "скакалка", "кукла", "медведь", "юла", "кубики", "ручка", "карандаш", "ножницы", "альбом", "фломастеры",
            "скотч", "линейка", "тетрадь"));

    int productQuantity;
    List<String> items = new ArrayList<>();
    Random rand = new Random();

    public ProductList(int productQuantity) {
        int key;
        this.productQuantity = productQuantity;

        if (productQuantity > productList.size()) {

            this.items = productList;
            this.productQuantity = productList.size();

        } else {

            for (int i = 0; i < productQuantity; i++) {
                do {
                    key = rand.nextInt(productList.size() - 1);
                } while (Arrays.asList(this.items).contains(productList.get(key)));

                this.items.add(i, productList.get(key));
                productList.remove(key);

            }
        }
    }
}
