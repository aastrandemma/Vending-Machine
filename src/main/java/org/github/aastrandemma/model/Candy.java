package org.github.aastrandemma.model;

public class Candy extends Product {
    private final CandyType candyType;
    private final boolean sugarFree;

    public Candy(CandyType candyType, int quantity, boolean sugarFree) {
        super(candyType.getArticleNumber(), candyType.getPrice(), candyType.getProductName(), quantity);
        this.candyType = candyType;
        this.sugarFree = sugarFree;
    }

    @Override
    public String examine() {
        if(sugarFree) {
            return "Item: " + getProductName() + " SUGAR FREE, Price: " + formatPrice(getPrice()) + "SEK";
        } else {
            return "Item: " + getProductName() + ", Price: " + formatPrice(getPrice()) + "SEK";
        }
    }

    @Override
    public String use() {
        return "{id: " + getId() + ", articleNumber: " + getArticleNumber()  + ", quantity: " + getQuantity() + ", sugarFree: " + sugarFree + "}";
    }
}