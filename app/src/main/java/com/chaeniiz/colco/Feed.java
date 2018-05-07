package com.chaeniiz.colco;

public class Feed {
    int thumbnail;
    String title;
    String explanation;

    int getThumbnail() {
        return this.thumbnail;
    }
    String getTitle() {
        return this.title;
    }
    String getExplanation() {
        return this.explanation;
    }

    Feed(int thumbnail, String title, String explanation) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.explanation = explanation;
    }
}
