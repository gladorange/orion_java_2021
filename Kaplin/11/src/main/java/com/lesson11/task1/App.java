package com.lesson11.task1;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class App
{
    public static void main( String[] args )
    {
        Supplier veganSupplier = new Supplier(11., 2400.,10);
        Shop shop = new Shop(veganSupplier.getRandomShipment(10));

        Comparator<ShopItem> randComparator = Shop.getComparators().get(
                ThreadLocalRandom.current().nextInt(Shop.getComparators().size())
        );


        System.out.println(getTableHead(List.of("Id", "Категория","Название", "Цена", "Количество")));
        shop.getItems().sort(randComparator);
        shop.getItems().forEach(System.out::println);
    }

    public static String getTableHead(List<String> headNames) {
        StringBuilder head = new StringBuilder();
        for (String name: headNames) {
            head.append(StringUtils.rightPad(StringUtils.abbreviate(name, 10), 13));
            head.append("|");
        }
        return head.toString();
    }
}
