package com.orion.java.homework3;

import java.util.Random;
import java.util.TreeSet;

public class FixPriceShop {
    public final static int FIC_PRICE=48;
    private final static int HAPPY_HOUR;
    static {
        HAPPY_HOUR =  (new Random()).nextInt(24);
    }
    private TreeSet<String> productsSet;

    public int checkItemPrice(String item, int hour){

        if( (item instanceof String) && productsSet.contains(item)){
            return ( (hour == HAPPY_HOUR)?FIC_PRICE/2:FIC_PRICE);
        }
        return -1;
    }

    public String[] getItems(){
        String[] products = new String[productsSet.size()];
        System.arraycopy(productsSet.toArray(),0,products,0,productsSet.size());
        return products;

    }

    public FixPriceShop(String... products) throws IllegalArgumentException {
        productsSet = new TreeSet<>();
        for (String product : products) {
            if( !(product instanceof String)){
                throw new IllegalArgumentException("Error:Product can't be null");
            }
            this.productsSet.add(product);
        }
    }
    public void buyItem(String item, int hour){
        int price =  checkItemPrice(item,hour);
        if(price==-1){
            System.out.println("товар <"+ item +"> не обнаружен");
        }else{
            productsSet.remove(item);
            System.out.println("товар <"+ item +"> продан по цене <"+ price +">");
        }
    }
}
