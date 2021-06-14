package com.kosarev;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Shop shop = new Shop();
        shop.fillRandomItems(10);
        var randComparator = Shop.getComparators().get(
                new Random().nextInt(Shop.getComparators().size())
        );

        System.out.println(" ID         | Категория    | Наименов.  | Цена       | Кол-во");
        System.out.println("------------+--------------+------------+------------+--------");
        shop.getItems().sort(randComparator);
        shop.getItems().forEach(System.out::println);
    }
}
