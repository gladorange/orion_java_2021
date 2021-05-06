package home.work3.happyhours.fixpriceshop;

import home.work3.happyhours.commands.CommandProxy;
import home.work3.happyhours.commands.Commands;
import home.work3.happyhours.commands.ICommandProxy;
import home.work3.happyhours.commands.ICommands;
import home.work3.happyhours.util.ConsoleHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StartShopping implements IStartShopping{

    public static List<FixPriceShop> listShop = new ArrayList<>();

    public static FixPriceShop currentShop;

    public StartShopping() {
        listShop.add(new FixPriceShop());
        listShop.add(new FixPriceShop());
        listShop.add(new FixPriceShop());
    }

    @Override
    public void start(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        ICommandProxy commandProxy = new CommandProxy();
        ICommands commands = new Commands();
        commands.showAvailableCommands();

        while (!line.equals("exit")){
            try {
                line= br.readLine();
            } catch (IOException e) {
                ConsoleHelper.showMessage("Ошибка чтения с консоли: " + e.getMessage());
            }
            commandProxy.doCommand(line.trim(),commands);
        }

    }
}
