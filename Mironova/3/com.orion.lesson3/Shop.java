package com.orion.java.lesson3;

import java.util.Arrays;

public class Shop {

    public static final int FIX_PRICE = 49;
    String name;
    lesson3.ProductList productList;
    lesson3.Action action;

    public Shop(String name, int productQuantity) {
        this.name = name;
        this.productList = new lesson3.ProductList(productQuantity);
    }

    public void setAction(lesson3.Action action){
        this.action = action;
    }

    void showAssortiment(){

        for (String item: this.productList.items){
            System.out.println(item);
        }

    }

    boolean checkItem(String item){
        return Arrays.stream(this.productList.items).allMatch(item::equals);
    }

    public int checkItemPrice(String item, int hour){

        //к одному регистру, если понадобится
        if(this.checkItem(item)){
            //TODO between
            return (hour >= this.action.timeStart && hour <= this.action.timeFinish) ? Math.round(FIX_PRICE/2) : FIX_PRICE;
        }else{
            return -1;
        }
    }

    //список ДОСТУПНЫХ товаров
    public String[] getItems(){

        return this.productList.items;

    }


    void buyItem(String item, int hour){

        //TODO надо ли к одному регистру всё это приводить?
        if(Arrays.asList(this.productList.items).contains(item)){
            //сокращаем массив на 1
            System.out.println("Вы приобрели " + item + " за " + this.checkItemPrice(item, hour) + "р.");
        }else{
            System.out.println("Товар не распозан, убедитесь, что вы верно ввели наименование.");
        }


    }
}
