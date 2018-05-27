package com.chaeniiz.colco.data.model;

public class Scrap {
    public int thumbnail;
    public String shopName;
    public String productName;
    public String personalColor;
    public String percentage;

    public int getThumbnail() {
        return this.thumbnail;
    }

    public String getShopName() {
        return this.shopName;
    }
    public String getProductName() {
        return this.productName;
    }
    public String getPersonalColor() { return this.personalColor; }
    public String getPercentage() { return this.percentage; }

    public Scrap(int thumbnail, String shopName, String productName, String personalColor, String percentage) {
        this.thumbnail = thumbnail;
        this.shopName = shopName;
        this.productName = productName;
        this.personalColor = personalColor;
        this.percentage = percentage;
    }
}
