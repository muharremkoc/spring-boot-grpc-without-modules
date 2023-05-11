package com.user.userservice.service;

import com.user.userservice.client.SocialMediaGrpcService;
import com.user.userservice.model.SocialMedia;
import com.user.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final SocialMediaGrpcService socialMediaGrpcService;

    public UserService(SocialMediaGrpcService socialMediaGrpcService) {
        this.socialMediaGrpcService = socialMediaGrpcService;
    }

    public User findUserByIdWithSocialMedias(int userId){
        var userSocialMedias = socialMediaGrpcService.findSocialMediasByUserId(userId);

        List<SocialMedia> socialMedias = new ArrayList<>();

        userSocialMedias.forEach(socialMedia -> socialMedias.add(new SocialMedia(socialMedia.getId(), socialMedia.getAppName(), socialMedia.getUserId())));

        var user = new User(1, "Muho", socialMedias);
        return user;
    }
}
