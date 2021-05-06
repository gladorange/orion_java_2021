package home.work3.happyhours.commands;

import home.work3.happyhours.util.ConsoleHelper;

public class CommandProxy implements ICommandProxy{

    @Override
    public void doCommand(String command, ICommands commands){
        switch (command){
            case "select shop":
                commands.selectShop();
                break;
            case "check price":
                commands.checkItemPrice();
                break;
            case "buy item":
                commands.buyItem();
                break;
            case "get items":
                commands.currentItemList();
                break;
            case "exit":
                ConsoleHelper.showMessage("Выполнен выход из приложения!");
                break;
            default:
                ConsoleHelper.showMessage("Неизвестная команда!");
                break;
        }
    }
}
