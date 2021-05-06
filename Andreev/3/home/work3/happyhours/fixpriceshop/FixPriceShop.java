package home.work3.happyhours.fixpriceshop;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FixPriceShop {

    public static final int FIX_PRICE = 50;

    private static int countShop = 1;

    private List<String> items;

    private int happyTime;

    public FixPriceShop(){
        if (countShop==1){
            items = Stream.of("Тарелка", "Кружка", "Конструктор", "Ведро", "Шампунь", "Часы").collect(Collectors.toList());
            happyTime = getRandomHappyTime();

        }
        if (countShop==2){
            items = Stream.of("Банка", "Кукла", "Лук", "Швабра", "Носки", "Жвачка").collect(Collectors.toList());
            happyTime = getRandomHappyTime();
        }
        if (countShop==3){
            items = Stream.of("Мел", "Гречка", "Зубная паста", "Зеркало", "Кофе", "Сахар").collect(Collectors.toList());
            happyTime = getRandomHappyTime();
        }
        countShop+=1;
    }

    private int getRandomHappyTime(){
        int happyTime = (int) (Math.random() * ((23) + 1));
        return happyTime;
    }

    public int checkItemPrice(String item, int hour){
        boolean isPresent = items.contains(item);
        if (!isPresent){
            return -1;
        }
        if (hour==happyTime){
            return FIX_PRICE/2;
        }
        return FIX_PRICE;
    }

    public void buyItem(String item, int hour){
        if (items.contains(item)){
            if (hour==happyTime){
                System.out.printf("Товар %s продан по цене %d!\n",item,FIX_PRICE/2);
            }else{
                System.out.printf("Товар %s продан по цене %d!\n",item,FIX_PRICE);
            }
            items.remove(item);
        }else{
            System.out.printf("Товар %s не обнаружен!\n",item);
        }
    }

    public List<String> getItems() {
        return items;
    }

    public int getHappyTime() {
        return happyTime;
    }
}
