package org.github.aastrandemma.model;

public enum CookieType {
    CHOCOLATE_BALL(7900, 10, "Chocolate ball"),
    PUNSCH_ROLL(7901, 10, "Punch roll"),
    CHOCOLATE_CHIP_COOKIE(7801, 10, "Chocolate chip cookie");

    private final int articleNumber;
    private final double price;
    private final String productName;

    CookieType(int articleNumber, double price, String productName) {
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