package home.work3.happyhours.commands;

import home.work3.happyhours.fixpriceshop.FixPriceShop;

public interface ICommands {
    void checkItemPrice();
    void buyItem();
    void selectShop();
    void currentItemList();
    void showAvailableCommands();
}
