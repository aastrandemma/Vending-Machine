package org.github.aastrandemma.data.model;

import org.github.aastrandemma.data.sequencer.ProductIdSequencer;
import org.github.aastrandemma.util.FormatData;

public class Drink implements Product {
    private final int id;
    private double price;
    private String productName;
    private final boolean sparkling;

    public Drink(double price, String productName, boolean sparkling) {
        this.id = ProductIdSequencer.nextProductId();
        setPrice(price);
        setProductName(productName);
        this.sparkling = sparkling;
    }

    @Override
    public String examine() {
        String sparkText = "No";
        if (sparkling) {
            sparkText = "Yes";
        }
        return "{id: " + getId() + ", Drink: " + getProductName() + ", Sparkling: " + sparkText + ", Price: " + FormatData.formatPrice(getPrice()) + "}";
    }

    @Override
    public String use() {
        String sparkText = "";
        if (sparkling) {
            sparkText = " with sparkles";
        }
        return "Enjoy your " + getProductName() + sparkText + "!";
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