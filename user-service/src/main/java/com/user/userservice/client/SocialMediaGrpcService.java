package com.user.userservice.client;

import com.socialmedia.socialmediaservice.server.SocialMedia;
import com.socialmedia.socialmediaservice.server.SocialMediaRequest;
import com.socialmedia.socialmediaservice.server.SocialMediaServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaGrpcService {
    @Value("${socialmedia.grpc.service.host}")
    private String postGrpcServiceHost;

    @Value("${socialmedia.grpc.service.port}")
    private int postGrpcServicePort;

    private final static Logger log = LoggerFactory.getLogger(SocialMediaGrpcService.class);

    public List<SocialMedia> findSocialMediasByUserId(int userId) {

        log.info(String.format("Request sending user id: %s", userId));

        ManagedChannel channel = ManagedChannelBuilder.forAddress(postGrpcServiceHost, postGrpcServicePort)
                .usePlaintext()
                .build();

        SocialMediaServiceGrpc.SocialMediaServiceBlockingStub stub = SocialMediaServiceGrpc.newBlockingStub(channel);

        var socialMediaRequest = SocialMediaRequest.newBuilder().setUserId(userId).build();
        var socialMediaResponse = stub.findSocialMediasByUserId(socialMediaRequest);
        log.info(String.format("Response from socialmedia grpc server %s", socialMediaResponse.toString()));
        channel.shutdown();
        var socialMediaList = socialMediaResponse.getSocialMediaList();
        return socialMediaList;
    }

}