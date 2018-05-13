package com.chaeniiz.colco;

public class Vote {
    int thumbnail;
    String shopName;
    String productName;
    String personalColor;
    String percentage;

    int getThumbnail() {
        return this.thumbnail;
    }
    String getShopName() {
        return this.shopName;
    }
    String getProductName() {
        return this.productName;
    }
    String getPersonalColor() { return this.personalColor; }
    String getPercentage() { return this.percentage; }

    Vote(int thumbnail, String shopName, String productName, String personalColor, String percentage) {
        this.thumbnail = thumbnail;
        this.shopName = shopName;
        this.productName = productName;
        this.personalColor = personalColor;
        this.percentage = percentage;
    }
}
