package com.user.userservice.model;

import java.util.List;

public class User {

    private int id;
    private String name;
    private List<SocialMedia> socialMedias;


    public User() {
    }

    public User(int id, String name, List<SocialMedia> socialMedias) {
        this.id = id;
        this.name = name;
        this.socialMedias = socialMedias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SocialMedia> getSocialMedias() {
        return socialMedias;
    }

    public void setSocialMedias(List<SocialMedia> socialMedias) {
        this.socialMedias = socialMedias;
    }
}
