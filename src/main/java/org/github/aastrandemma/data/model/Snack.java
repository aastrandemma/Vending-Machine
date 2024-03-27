package org.github.aastrandemma.data.model;

import org.github.aastrandemma.data.sequencer.ProductIdSequencer;
import org.github.aastrandemma.util.FormatData;

public class Snack implements Product {
    private final int id;
    private double price;
    private String productName;
    private final boolean spicy;

    public Snack(double price, String productName, boolean spicy) {
        this.id = ProductIdSequencer.nextProductId();
        setPrice(price);
        setProductName(productName);
        this.spicy = spicy;
    }

    @Override
    public String examine() {
        String spicyText = "No";
        if (spicy) {
            spicyText = "Yes";
        }
        return "{id: " + getId() + ", Snack: " + getProductName() + ", Spicy: " + spicyText + ", Price: " + FormatData.formatPrice(getPrice()) + "}";
    }

    @Override
    public String use() {
        String spicyText = "";
        if (spicy) {
            spicyText = ", HOT HOT HOT";
        }
        return "Enjoy your " + getProductName() + spicyText + "!";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        if (productName == null) throw new IllegalArgumentException("Product name is null.");
        this.productName = productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}