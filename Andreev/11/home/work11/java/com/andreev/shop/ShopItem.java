package home.work11.java.com.andreev.shop;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ShopItem {

    @Getter
    private String category;
    @Getter
    private double price;
    @Getter
    private String title;
    @Getter
    private int quantity;
    private String id;

    public ShopItem(String category, double price, String title, int count, String id) {
        this.category = category;
        this.price = price;
        this.title = title;
        this.quantity = count;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShopItem shopItem = (ShopItem) o;

        return new EqualsBuilder().append(price, shopItem.price).append(quantity, shopItem.quantity).append(category, shopItem.category).append(title, shopItem.title).append(id, shopItem.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(category).append(price).append(title).append(quantity).append(id).toHashCode();
    }

    @Override
    public String toString() {
        return StringUtils.abbreviate(id,10) + " "
                + StringUtils.abbreviate(category,10)
                + " " + StringUtils.abbreviate(title,10)
                + " " + price + " " + quantity;
    }
}
