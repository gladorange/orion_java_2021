package com.kosarev;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class ShopItem {
    public static final int ID_LENGTH = 25;

    private String id;
    private String category;
    private String name;
    private double price;
    private int amount;

    public ShopItem() {
    }

    public ShopItem(String id, String category, String name, double price, int amount) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;

        return new EqualsBuilder().append(price, shopItem.price)
                .append(amount, shopItem.amount)
                .append(id, shopItem.id)
                .append(category, shopItem.category)
                .append(name, shopItem.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        return StringUtils.rightPad(StringUtils.abbreviate(id, 10), 12) + "|" +
               StringUtils.rightPad(StringUtils.abbreviate(category, 12), 14) + "|" +
               StringUtils.rightPad(StringUtils.abbreviate(name, 10), 12) + "|" +
               StringUtils.rightPad(StringUtils.abbreviate(""+price, 10), 12) + "|" +
               StringUtils.rightPad(StringUtils.abbreviate(""+amount, 10), 12);
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
