package com.orion.java.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Shop {

    public static final int FIX_PRICE = 49;
    String name;
    ProductList productList;
    Action action;

    public Shop(String name, int productQuantity) {
        this.name = name;
        this.productList = new ProductList(productQuantity);
    }

    public void setAction(Action action){
        this.action = action;
    }

    void showAssortiment(){

        for (String item: this.productList.items){
            System.out.println(item);
        }

    }

    int checkItem(String item){
        return this.productList.items.indexOf(item);
    }

    public int checkItemPrice(String item, int hour){

        //к одному регистру, если понадобится
        if(this.checkItem(item.toUpperCase()) != -1){
            return (hour >= this.action.timeStart && hour <= this.action.timeFinish) ? Math.round(FIX_PRICE/2) : FIX_PRICE;
        }else{
            return -1;
        }
    }

    public List<String> getItems(){
        return this.productList.items;
    }


    void buyItem(String item, int hour){

        System.out.println("Вы приобрели " + item + " за " + this.checkItemPrice(item, hour) + "р.");
        this.productList.items.remove(item);



    }
}
