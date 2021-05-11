import java.util.Scanner;

import java.util.Scanner;

public class Deal {

    public static Scanner in = new Scanner(System.in);

    public static void makeADeal(Shop shop) {

        System.out.println("Добро пожаловать в" + shop.name);
        System.out.println("Ознакомтесь с ассортиментом");
        shop.showAssortiment();

        System.out.println("и ведите название выбранного товара: ");
        String itemName = in.nextLine();

        while (shop.checkItem(itemName) == -1) {
            System.out.println("Товар не существует или приобретён. выбериет другой товар");
            itemName = in.nextLine();
        }

        System.out.println("Введите планируемое время совершения покупки: ");
        int hour = in.nextInt();

        while (hour < 0 || hour > 24) {
            System.out.println("Укажите время в диапазоне от 0 до 24 часов");
            hour = in.nextInt();
        }

        System.out.println("Наиболее благопрятное время совершения покупки мужду " + shop.action.timeStart + " и " + shop.action.timeFinish + " часами");

        shop.buyItem(itemName, hour);

    }

}
