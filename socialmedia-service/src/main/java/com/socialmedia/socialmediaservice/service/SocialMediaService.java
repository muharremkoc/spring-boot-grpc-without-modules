package com.socialmedia.socialmediaservice.service;

import com.socialmedia.socialmediaservice.client.UserGrpcService;
import com.socialmedia.socialmediaservice.model.SocialMedia;
import com.socialmedia.socialmediaservice.model.SocialMediaResponseWithUser;
import com.socialmedia.socialmediaservice.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SocialMediaService {

    private final UserGrpcService userGrpcService;

    @Autowired
    public SocialMediaService(UserGrpcService userGrpcService) {
        this.userGrpcService = userGrpcService;
    }

    public SocialMediaResponseWithUser findSocialMediaByIdWithUser(int socialMediaId) {
        var socialMedia = filterSocialMedia(socialMediaId);
        var userResponse = userGrpcService.findUserById(socialMedia.getUserId());

        UserResponse user = new UserResponse(userResponse.getId(), userResponse.getName());
        var postResponseWithUser = new SocialMediaResponseWithUser(socialMedia.getId(), socialMedia.getAppName(), user);
        return postResponseWithUser;
    }

    private SocialMedia filterSocialMedia(int socialMediaId) {
        List<SocialMedia> socialMedias = Arrays.asList(
                new SocialMedia(1, "FACEBOOK" , 1),
                new SocialMedia(2, "GOOGLE" , 1),
                new SocialMedia(3, "INSTAGRAM" , 1)

        );
        var filteredSocialMedia = socialMedias.stream().filter(socialMedia -> socialMedia.getId() == socialMediaId).findFirst();
        return filteredSocialMedia.get();
    }
}
