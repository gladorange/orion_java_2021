package com.lesson3.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FixPriceShop {
    private final static int FIX_MARKET_PRICE = new Random().nextInt(100 - 10 ) + 10;

    private String [] items;
    private int happyHour;


    public FixPriceShop( String...items ){
        this.items = items;
        this.happyHour = new Random().nextInt( 24 );
    }


    public static int getFixMarketPrice() {
        return FIX_MARKET_PRICE;
    }

    public int getHappyHour() {
        return happyHour;
    }

    private String[] getItems(){
        List<String> productList = new ArrayList<>( Arrays.asList( items ) );
        for( String item : items ){
            if( item == null ){
                productList.remove(null );
            }
        }
        items = productList.toArray( new String[0] );
        return items;
    }

    private int checkItemPrice( String item, int hour ){
        for( String itm : getItems() ){
            if( itm.equals( item ) ){
                return ( hour == happyHour ) ? FIX_MARKET_PRICE / 2 : FIX_MARKET_PRICE;
            }
        }
        return -1;
    }

    public void buyItem( String item, int hour ){
        int price = checkItemPrice( item, hour );
        if( price == -1 ){
            System.out.printf("Товар %s не обнаружен \n", item );
        }else {
            for( int i = 0; i < items.length; i++ ){
                if( item.equals( items[i] ) ){
                    items[i] = null;
                }
            }
            System.out.printf( "Товар %s продан по цене %s \n", item, price );
        }
    }

    /**
     * Метод возвращающий случайный товар из массива.
     * @return String item
     */
    public String getRandomItem(){
        int randomIndex = new Random().nextInt( items.length );
        return items[randomIndex];
    }
}
