package com.socialmedia.socialmediaservice.model;

public class SocialMedia {

    private int id;
    private String appName;
    private int userId;

    public SocialMedia() {
    }

    public SocialMedia(int id, String appName, int userId) {
        this.id = id;
        this.appName = appName;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
