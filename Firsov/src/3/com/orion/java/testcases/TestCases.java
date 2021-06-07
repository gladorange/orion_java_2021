package com.orion.java.testcases;

import com.orion.java.homework3.FixPriceShop;
import com.orion.java.homework3.Main;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestCases {

    @Test
    /**
     *  Тестирование выкидываемого исключения конструктором класса FixPriceShop.
     */
    public void testNumberBoxOfException() {
        Exception exceptionBox = assertThrows(IllegalArgumentException.class, () -> {
            FixPriceShop firstShop = new FixPriceShop("Ножниц",null,"Наушники");
        });

        String expectedMessage = "Error:Product can't be null";
        String actualMessageBox = exceptionBox.getMessage();

        assertTrue(actualMessageBox.contains(expectedMessage));

    }

    @Test
    /**
     * Тестирование методов  класса FixPriceShop.
     */
    public void checkItemPriceTest() {
        FixPriceShop firstShop = new FixPriceShop("Ножниц","Карандаши","Наушники");
        int price = FixPriceShop.FIC_PRICE;
        int notFound = -1;
        int firstShopHappyHour =  Main.getHappyHour("Ножниц",firstShop,price);

        assertEquals(price/2, firstShop.checkItemPrice("Ножниц",firstShopHappyHour));

        FixPriceShop secondShop = new FixPriceShop("Тетрадки","Ручки","Дневник");
        int secondShopHappyHour =  Main.getHappyHour("Ручки",secondShop,price);
        assertEquals(price/2, secondShop.checkItemPrice("Ручки",secondShopHappyHour));

        FixPriceShop thirdShop = new FixPriceShop("Скотч","Перчатки");
        int thirdShopHappyHour = Main.getHappyHour("Скотч",thirdShop,price);
        assertEquals(price, thirdShop.checkItemPrice("Перчатки",thirdShopHappyHour+1));

        assertEquals(notFound, thirdShop.checkItemPrice("Перчатки123",thirdShopHappyHour+1));
        assertEquals(notFound, thirdShop.checkItemPrice(null,thirdShopHappyHour));

        firstShop.buyItem("Ножниц",firstShopHappyHour);
        assertEquals(firstShop.getItems(), Arrays.asList("Карандаши","Наушники").toArray());
        assertEquals(notFound, firstShop.checkItemPrice("Ножниц",firstShopHappyHour));


    }
}
