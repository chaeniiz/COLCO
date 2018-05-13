package com.chaeniiz.colco;

public class Feed {
    int thumbnail;
    int profile;
    String id;
    String personalColor;
    String explanation;

    int getThumbnail() {
        return this.thumbnail;
    }
    int getProfile() { return this.profile; }
    String getId() {
        return this.id;
    }
    String getPersonalColor() { return this.personalColor; }
    String getExplanation() {
        return this.explanation;
    }

    Feed(int thumbnail, int profile, String id, String personalColor, String explanation) {
        this.thumbnail = thumbnail;
        this.profile = profile;
        this.id = id;
        this.personalColor = personalColor;
        this.explanation = explanation;
    }
}
