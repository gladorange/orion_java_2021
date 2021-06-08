package com.orion.java.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    /**
     * Функция получения счастливого часа в магазине.
     * @param product
     * @param fixPriceShop
     * @param fixPrice
     * @return В случае успеха возвращает час,иначе -1.
     */
    public static int getHappyHour(String product,FixPriceShop fixPriceShop,int fixPrice){
        for (int i = 0; i < 24; i++) {
            if( fixPriceShop.checkItemPrice(product,i) == fixPrice/2 ){
                return i;
            }
        }
        return -1;
    }

    /**
     * Точка взода в приложение.
     * @param args
     *
     * Добавляем в список три магазина с различными товарами.
     * Проходим по всему списку,определяем выборочно товар для покупки.
     * Определяем счастливый час в магазине.
     * Покупаем товар в счастливый час.
     * Покупаем повторно,чтобы убедиться,что товара нет.
     */
    public static void main(String[] args) {
        List<FixPriceShop> fixPriceShopsArray = new ArrayList<>();
        fixPriceShopsArray.add(new FixPriceShop("Ножницы","Карандаши","Наушники","Топор"));
        fixPriceShopsArray.add(new FixPriceShop("Тетрадки","Ручки","Дневник"));
        fixPriceShopsArray.add(new FixPriceShop("Скотч","Перчатки"));
        for (FixPriceShop shop : fixPriceShopsArray) {
            System.out.println("-----start------");
            String[] firstShopProducts = shop.getItems();
            int randomProductNumberFirstShop = (new Random()).nextInt(firstShopProducts.length);
            int firstShopHappyHour = getHappyHour(firstShopProducts[randomProductNumberFirstShop],shop,FixPriceShop.FIC_PRICE);
            shop.buyItem(firstShopProducts[randomProductNumberFirstShop],firstShopHappyHour);
            shop.buyItem(firstShopProducts[randomProductNumberFirstShop],firstShopHappyHour);
            System.out.println("----end-----");
        }
    }
}
