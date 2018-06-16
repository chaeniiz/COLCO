package com.chaeniiz.colco.data.model;

public class UploadedItem {
    public int thumbnail;
    public String itemName;

    public int getThumbnail() {
        return this.thumbnail;
    }

    public String getItemName() {
        return this.itemName;
    }

    public UploadedItem(int thumbnail, String itemName) {
        this.thumbnail = thumbnail;
        this.itemName = itemName;
    }
}
