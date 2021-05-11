import java.util.Scanner;

public class Deal {

    public static Scanner in = new Scanner(System.in);

    public static void makeADeal(Shop shop) {

        System.out.println("Добро пожаловать в" + shop.name);
        System.out.println("Ознакомтесь с ассортиментом");
        shop.showAssortiment();

        System.out.println("и ведите название выбранного товара: ");
        String itemName = in.nextLine();
        System.out.println("Введите планируемое время совершения покупки: ");
        int hour = in.nextInt();

        System.out.println("Наиболее благопрятное время совершения покупки мужду " + shop.action.timeStart + " и " + shop.action.timeFinish + " часами");
        /*
        while (!shop.checkItem(itemName)) {
            System.out.println("Товар не существует или приобретён. выбериет другой товар");
        }

         */

    }

}
