package home.work11.java.com.andreev.shop;

import com.andreev.store.ItemSorters;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    @Getter
    private List<ShopItem> items;
    @Getter
    private List<Comparator<ShopItem>> comparators;

    public Shop() {
        this.items = getListItems();
        comparators = getListComparators();
    }

    private List<ShopItem> getListItems(){
        List<ShopItem> list = new ArrayList<>();
        int length = 25;
        list.add(new ShopItem("Бакалея",12.5,"Макароны",3, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Мясо",30.7,"Говядина",8, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Бакалея",9.,"Рис",6, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Бакалея",10.2,"Гречка",14, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Мясо",27.8,"Свинина",56, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Полуфабрикаты",14.7,"Пельмени",54, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Полуфабрикаты",12.7,"Вареники",76, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Молочный продукт",8.6,"Молоко",35, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Молочный продукт",9.6,"Кефир",24, RandomStringUtils.randomAlphanumeric(length,length)));
        list.add(new ShopItem("Бакалея",4.5,"Хлеб",68, RandomStringUtils.randomAlphanumeric(length,length)));
        return list;
    }

    private List<Comparator<ShopItem>> getListComparators(){
        List<Comparator<ShopItem>> list = new ArrayList<>();
        list.add(ItemSorters::sortByCategory);
        list.add(ItemSorters::sortByPrice);
        list.add(ItemSorters::sortByTitle);
        list.add(ItemSorters::sortByQuantity);
        return list;
    }


}
