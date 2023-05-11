package com.socialmedia.socialmediaservice.controller;

import com.socialmedia.socialmediaservice.model.SocialMediaResponseWithUser;
import com.socialmedia.socialmediaservice.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialMedia")
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping(path = "/{socialMediaId}/users")
    public SocialMediaResponseWithUser findSocialMediaByIdWithUser(@PathVariable int socialMediaId) {
        return socialMediaService.findSocialMediaByIdWithUser(socialMediaId);
    }

}
