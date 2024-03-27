package org.github.aastrandemma.model;

import java.text.DecimalFormat;

public abstract class Product {
    private final int id;
    private static int sequencer = 0;
    private final int articleNumber;
    private final double price;
    private String productName;
    private int quantity;

    public Product(int articleNumber, double price, String productName, int quantity) {
        this.id = setId();
        this.articleNumber = articleNumber;
        this.price = price;
        this.quantity = quantity;
        setProductName(productName);
    }

    private static int setId() {
        return ++sequencer;
    }

    private void setProductName(String productName) {
        if (productName == null) throw new IllegalArgumentException("Product name is null.");
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }

    public int getId() {
        return id;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }

    public abstract String examine(); // display details of product

    public abstract String use(); // display important details of product id, articleNumber, quantity
}