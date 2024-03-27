package org.github.aastrandemma.model;

public class Soda extends Product {
    private final SodaType sodaType;
    private String taste;

    public Soda(SodaType sodaType, String taste, int quantity) {
        super(sodaType.getArticleNumber(), sodaType.getPrice(), sodaType.getProductName(), quantity);
        this.sodaType = sodaType;
        setTaste(taste);
    }

    private void setTaste(String taste) {
        if (taste == null) throw new IllegalArgumentException("Taste is null");
        this.taste = taste;
    }

    @Override
    public String examine() {
        String descrSparkle = "No";
        if (sodaType.getSparkle()) {
            descrSparkle = "Yes";
        }
        return "Item: " + getProductName() + ", Price: " + formatPrice(getPrice()) + "SEK" + ", Taste: " + taste + ", Sparkle: " + descrSparkle;
    }

    @Override
    public String use() {
        return "{id: " + getId() + ", articleNumber: " + getArticleNumber()  + ", quantity: " + getQuantity() + ", taste: " + taste + "}";
    }
}