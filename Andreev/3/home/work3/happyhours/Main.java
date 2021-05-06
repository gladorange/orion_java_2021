package home.work3.happyhours;

import home.work3.happyhours.fixpriceshop.IStartShopping;
import home.work3.happyhours.fixpriceshop.StartShopping;

public class Main {

    public static void main(String[] args) {

        IStartShopping startShopping = new StartShopping();
        startShopping.start();

    }

}
