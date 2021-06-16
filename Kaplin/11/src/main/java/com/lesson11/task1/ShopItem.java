package com.lesson11.task1;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class ShopItem {
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
        String separator = "|";
        int maxWidth = 10;
        int maxSize = 13;
        return StringUtils.rightPad(StringUtils.abbreviate(id, maxWidth), maxSize)
                + separator +
               StringUtils.rightPad(StringUtils.abbreviate(category, maxWidth), maxSize)
                + separator +
               StringUtils.rightPad(StringUtils.abbreviate(name, maxWidth), maxSize)
                + separator +
               StringUtils.rightPad(StringUtils.abbreviate(String.valueOf(price), maxWidth), maxSize)
                + separator +
               StringUtils.rightPad(StringUtils.abbreviate(String.valueOf(amount), maxWidth), maxSize);
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
