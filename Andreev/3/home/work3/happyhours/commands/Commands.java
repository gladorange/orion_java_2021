package home.work3.happyhours.commands;

import home.work3.happyhours.fixpriceshop.StartShopping;
import home.work3.happyhours.util.ConsoleHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.List;

public class Commands implements ICommands{
    @Override
    public void checkItemPrice() {
        if (StartShopping.currentShop!=null) {
            ConsoleHelper.showMessage("Введите через пробел название товара и час (от 0 до 23):");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String[] line = br.readLine().split(" ");
                int checkResult = StartShopping.currentShop.checkItemPrice(line[0], Integer.parseInt(line[1]));
                if (checkResult == -1) {
                    ConsoleHelper.showMessage("Товар " + line[0] + " не обнаружен!");
                } else {
                    ConsoleHelper.showMessage("Стоимость товара = " + checkResult);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            ConsoleHelper.showMessage("Сначала выберите магазин!");
        }
    }

    @Override
    public void buyItem() {
        if (StartShopping.currentShop!=null) {
            ConsoleHelper.showMessage("Введите через пробел название товара и час покупки (от 0 до 23):");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String[] line = br.readLine().split(" ");
                StartShopping.currentShop.buyItem(line[0], Integer.parseInt(line[1]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            ConsoleHelper.showMessage("Сначала выберите магазин!");
        }
    }

    @Override
    public void selectShop() {
        ConsoleHelper.showMessage("Введите номер магазина (1,2 или 3):");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String shopNumber = br.readLine();
            switch (shopNumber){
                case "1":
                    StartShopping.currentShop = StartShopping.listShop.get(0);
                    List<String> listItemsOne = StartShopping.currentShop.getItems();
                    ConsoleHelper.showMessage("Товары в наличие:");
                    ConsoleHelper.showMessage(listItemsOne.toString());
                    ConsoleHelper.showMessage("В магазине действует скидка 50% в счастливый час = " + StartShopping.currentShop.getHappyTime());
                    break;
                case "2":
                    StartShopping.currentShop = StartShopping.listShop.get(1);
                    List<String> listItemsTwo = StartShopping.currentShop.getItems();
                    ConsoleHelper.showMessage("Товары в наличие:");
                    ConsoleHelper.showMessage(listItemsTwo.toString());
                    ConsoleHelper.showMessage("В магазине действует скидка 50% в счастливый час = " + StartShopping.currentShop.getHappyTime());
                    break;
                case "3":
                    StartShopping.currentShop = StartShopping.listShop.get(2);
                    List<String> listItemsThree = StartShopping.currentShop.getItems();
                    ConsoleHelper.showMessage("Товары в наличие:");
                    ConsoleHelper.showMessage(listItemsThree .toString());
                    ConsoleHelper.showMessage("В магазине действует скидка 50% в счастливый час = " + StartShopping.currentShop.getHappyTime());
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void currentItemList() {
        if (StartShopping.currentShop!=null) {
            ConsoleHelper.showMessage("Доступные товары для покупки:");
            ConsoleHelper.showMessage(StartShopping.currentShop.getItems().toString());
        }else {
            ConsoleHelper.showMessage("Сначала выберите магазин!");
        }
    }

    @Override
    public void showAvailableCommands() {
        StringBuilder sb = new StringBuilder();
        sb.append("select shop - выбор магазина;\n")
                .append("check price - проверка цены товара;\n")
                .append("buy item - покупка товара;\n")
                .append("get items - список доступных товаров;\n")
                .append("exit - выход из приложения.");
        ConsoleHelper.showMessage(sb.toString());
    }
}
