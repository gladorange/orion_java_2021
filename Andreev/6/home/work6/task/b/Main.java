package home.work6.task.b;

import home.work6.task.b.gasoline.GasolineApp;
import home.work6.task.b.mobileapp.MobileApp;


public class Main {

    public static void main(String[] args) {

        GasolineApp appGasoline = new GasolineApp();
        appGasoline.doTaskOne();
        MobileApp appMobile = new MobileApp();
        appMobile.doTaskTwo();

    }



}
