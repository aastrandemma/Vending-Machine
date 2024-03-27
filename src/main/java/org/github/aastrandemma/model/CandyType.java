package org.github.aastrandemma.model;

public enum CandyType {
    SNICKERS(8801,15, "Snickers original"),
    DAIM(7801,12, "Daim original"),
    WERTHERS_ORIGINAL(3345,25, "Werther's original");

    private final int articleNumber;
    private final double price;
    private final String productName;

    CandyType(int articleNumber, double price, String productName) {
        this.articleNumber = articleNumber;
        this.price = price;
        this.productName = productName;
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
}