package com.lesson3;

import com.lesson3.task1.FixPriceShop;

import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        FixPriceShop shop1 = new FixPriceShop( "Item 1","Item 2","Item 3","Item 4","Item 5" );

        FixPriceShop shop2 = new FixPriceShop( "Item 6","Item 7","Item 8","Item 9","Item 10" );

        FixPriceShop shop3 = new FixPriceShop( "Item 11","Item 12","Item 13","Item 14","Item 15" );

        System.out.println( "Цена для магазинов: " + FixPriceShop.getFixMarketPrice() );

        System.out.println("/------------------------------------------------/");
        System.out.println( "Счастливый час для первого магазина: " + shop1.getHappyHour() );
        String itemShop1 = shop1.getRandomItem();
        shop1.buyItem( itemShop1,12 );
        shop1.buyItem( itemShop1,1 );

        System.out.println("/------------------------------------------------/");
        System.out.println( "Счастливый час для второго магазина: " + shop2.getHappyHour() );
        String itemShop2 = shop2.getRandomItem();
        shop2.buyItem( itemShop2,5 );
        shop2.buyItem( itemShop2,11 );
        
        System.out.println("/------------------------------------------------/");
        System.out.println( "Счастливый час для третьего магазина: " + shop3.getHappyHour() );
        String itemShop3 = shop3.getRandomItem();
        shop3.buyItem( itemShop3,16 );
        shop3.buyItem( itemShop3,16 );

    }
}
