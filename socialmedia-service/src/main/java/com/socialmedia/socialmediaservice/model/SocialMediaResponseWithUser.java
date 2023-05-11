package com.socialmedia.socialmediaservice.model;

public class SocialMediaResponseWithUser {
    private int id;

    private String appName;

    private UserResponse userResponse;

    public SocialMediaResponseWithUser() {
    }

    public SocialMediaResponseWithUser(int id, String appName, UserResponse userResponse) {
        this.id = id;
        this.appName = appName;
        this.userResponse = userResponse;
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

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
