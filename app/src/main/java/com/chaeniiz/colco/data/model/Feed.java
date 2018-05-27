package com.chaeniiz.colco.data.model;

public class Feed {
    public int thumbnail;
    public int profile;
    public String id;
    public String personalColor;
    public String explanation;

    public int getThumbnail() {
        return this.thumbnail;
    }
    public int getProfile() { return this.profile; }
    public String getId() {
        return this.id;
    }
    public String getPersonalColor() { return this.personalColor; }
    public String getExplanation() {
        return this.explanation;
    }

    public Feed(int thumbnail, int profile, String id, String personalColor, String explanation) {
        this.thumbnail = thumbnail;
        this.profile = profile;
        this.id = id;
        this.personalColor = personalColor;
        this.explanation = explanation;
    }
}
