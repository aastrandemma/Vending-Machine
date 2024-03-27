package org.github.aastrandemma.model;

public enum SodaType {
    PEPSI(5501,20, "Pepsi", true),
    PEPSI_MAX(5502,20,"Pepsi Max", true),
    LOKA(2010,20, "Loka", true),
    FESTIS(1005,20, "Festis", false);

    private final int articleNumber;
    private final double price;
    private final String productName;
    private final boolean sparkle;

    SodaType(int articleNumber, double price, String productName, boolean sparkle) {
        this.articleNumber = articleNumber;
        this.price = price;
        this.productName = productName;
        this.sparkle = sparkle;
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

    public boolean getSparkle() {
        return sparkle;
    }
}