package org.github.aastrandemma.model;

public class Cookie extends Product {
    private final CookieType cookieType;
    private final boolean seasonProduct;

    public Cookie(CookieType cookieType, int quantity, boolean seasonProduct) {
        super(cookieType.getArticleNumber(), cookieType.getPrice(), cookieType.getProductName(), quantity);
        this.cookieType = cookieType;
        this.seasonProduct = seasonProduct;
    }

    @Override
    public String examine() {
        if (seasonProduct) {
            return "Item: " + getProductName() + ", Price: " + formatPrice(getPrice()) + "SEK, only available this spring!";
        } else {
            return "Item: " + getProductName() + ", Price: " + formatPrice(getPrice()) + "SEK";
        }
    }

    @Override
    public String use() {
        return "{id: " + getId() + ", articleNumber: " + getArticleNumber()
                + ", quantity: " + getQuantity() + ", seasonProduct: " + seasonProduct +"}";
    }
}