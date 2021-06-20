package com.orion.java.homework11;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        List<ShopItem> shopItems = new ArrayList<>();
        ShopItem o1 = new ShopItem("meet",340.0,"pork",23);
        ShopItem o2 = new ShopItem("fish",220.0,"seledka",15);
        ShopItem o3 = new ShopItem("milk",25.0,"redPrice",100);
        ShopItem o4= new ShopItem("bread",12.22222222222222222225,"redPrice",203);
        shopItems.add(o1);
        shopItems.add(o2);
        shopItems.add(o3);
        shopItems.add(o4);
        shopItems.sort(ShopItem.itemShopComparators.get(  (new Random()).nextInt(ShopItem.itemShopComparators.size()) ));
        for (ShopItem shIt:shopItems) {
            System.out.println(shIt);
        }


    }
}
