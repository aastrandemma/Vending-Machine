package org.github.aastrandemma.data.model;

import org.github.aastrandemma.data.sequencer.ProductIdSequencer;
import org.github.aastrandemma.util.FormatData;

public class Sandwich implements Product {
    private final int id;
    private double price;
    private String productName;
    private final boolean gluten;
    private final boolean lactose;


    public Sandwich(double price, String productName, boolean gluten, boolean lactose) {
        this.id = ProductIdSequencer.nextProductId();
        setPrice(price);
        setProductName(productName);
        this.gluten = gluten;
        this.lactose = lactose;
    }

    @Override
    public String examine() {
        String glutenText = "No";
        String lactoseText = "No";
        if (gluten) {
            glutenText = "Yes";
        }
        if (lactose) {
            lactoseText = "Yes";
        }
        return "{id: " + getId() + ", Snack: " + getProductName() + ", Contains gluten: " + glutenText
                + ", Contains lactose: " + lactoseText + ", Price: " + FormatData.formatPrice(getPrice()) + "}";
    }

    @Override
    public String use() {
        String glutenText = "";
        String lactoseText = "";
        if (gluten && lactose) {
            glutenText = " (CONTAINS gluten and lactose)";
        }
        if (lactose && !gluten) {
            lactoseText = " (CONTAINS lactose)";
        }
        if (gluten && !lactose) {
            glutenText = " (CONTAINS gluten)";
        }
        return "Enjoy your " + getProductName() + glutenText + lactoseText + "!";
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