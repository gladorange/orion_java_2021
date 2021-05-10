package com.lesson3.task1;


public class Consumer {

    FixPriceShop shop;
    public Consumer(FixPriceShop shop) {
        this.shop = shop;
    }

    public int checkBestTime(String item) {
        int fixPrice = FixPriceShop.getFixPrice();
        int bestTime = -1;
        for(int i = 0; i < 24; i++) {
            int price = shop.checkItemPrice(item, i);
            if(price != -1 && price < fixPrice) {
                bestTime = i;
                System.out.println("Оптимальное время для покупки \"" + item + "\" " + i + " ч.");
                break;
            } else if (price == -1) {
                break;
            }

        }
        return bestTime;
    }

    public void buyItemInShop(String item, int hour) {
        shop.buyItem(item, hour);
    }

    public FixPriceShop getShop() {
        return shop;
    }

    public void setShop(FixPriceShop shop) {
        this.shop = shop;
    }
}
