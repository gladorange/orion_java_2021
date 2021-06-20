package com.orion.java.homework11;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShopItem {
    private String category;
    private double Price;
    private String name;
    private int count;
    private String ID;
   static final List<Comparator<ShopItem>> itemShopComparators = new ArrayList<>();

    static {
          ShopItem.itemShopComparators.add(ItemSorters::sortByCategory);
          ShopItem.itemShopComparators.add(ItemSorters::sortByTitle);
          ShopItem.itemShopComparators.add(ItemSorters::sortByPrice);
          ShopItem.itemShopComparators.add(ItemSorters::sortByQuantity);
    }

    public ShopItem(String category, double price, String name, int count) {
        if(category == null  || name == null  ){
            throw new NullPointerException("Error:Arguments can't be null");
        }
        if ( price < 0){
            throw new IllegalArgumentException("Error:Price can't less than |0|");
        }
        if ( count < 0){
            throw new IllegalArgumentException("Error:Count can't less than |0|");
        }
        this.category = category;
        this.Price = price;
        this.name = name;
        this.count = count;
        this.ID = (new RandomStringUtils()).random(25,true,true);
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder()
                .append(ID)
                .append(category)
                .append(Price)
                .append(name)
                .append(count)
                .toHashCode();
    }
    @Override
    public boolean equals(final Object obj){
        if(obj instanceof ShopItem){
            final ShopItem other = (ShopItem) obj;
            return new EqualsBuilder()
                    .append(ID, other.ID)
                    .append(category, other.category)
                    .append(Price, other.Price)
                    .append(name, other.name)
                    .append(count, other.count)
                    .isEquals();
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        String price = ((Double)this.Price).toString();
        String count = ((Integer)this.count).toString();
        return
                "ID='" + (ID.length()>10?StringUtils.abbreviate(ID,10):ID) + '\'' +
                "category='" + (category.length()>10?StringUtils.abbreviate(category,10):category) + '\'' +
                        ", name='" + (name.length()>10?StringUtils.abbreviate(name,10):name) + '\'' +
                ", Price=" +      (price.length()>10?StringUtils.abbreviate(price,10):price)+
                ", count=" +  (count.length()>10?StringUtils.abbreviate(count,10):count);
    }

    public static class ItemSorters {
        public static int sortByCategory(ShopItem a, ShopItem b){
            System.out.println(new Throwable()
                            .getStackTrace()[0]
                             .getMethodName());
            return a.category.compareTo(b.category);
        }
        public static int sortByTitle(ShopItem a, ShopItem b){
            System.out.println(new Throwable()
                    .getStackTrace()[0]
                    .getMethodName());
            return a.name.compareTo(b.name);
        }
        public static int sortByPrice(ShopItem a, ShopItem b){
            System.out.println(new Throwable()
                    .getStackTrace()[0]
                    .getMethodName());
            return  Double.compare(a.Price,b.Price);
        }
        public static int sortByQuantity(ShopItem a, ShopItem b){
            System.out.println(new Throwable()
                    .getStackTrace()[0]
                    .getMethodName());
            return   Integer.compare(a.count,b.count);
        }

    }
}
