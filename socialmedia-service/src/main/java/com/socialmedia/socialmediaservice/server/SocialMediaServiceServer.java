package com.socialmedia.socialmediaservice.server;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class SocialMediaServiceServer extends SocialMediaServiceGrpc.SocialMediaServiceImplBase {

    private final static Logger log = LoggerFactory.getLogger(SocialMediaServiceServer.class);

    public void findSocialMediasByUserId(SocialMediaRequest request, StreamObserver<SocialMediaResponse> responseObserver){

        log.info(String.format("Request received: %s", request.toString()));

        var userSocialMedias = filterSocialMedia(request.getUserId());

        var userSocialMediasResponse = SocialMediaResponse.newBuilder().addAllSocialMedia(userSocialMedias).build();

        log.info(String.format("Response SocialMedia: %s",userSocialMediasResponse.toString()));

        responseObserver.onNext(userSocialMediasResponse);
        responseObserver.onCompleted();
    }

    private List<SocialMedia> filterSocialMedia(int userId){
        List<SocialMedia> socialMedias = Arrays.asList(
                SocialMedia.newBuilder().setId(1).setAppName("FACEBOOK").setUserId(1).build(),
                SocialMedia.newBuilder().setId(2).setAppName("GOOGLE").setUserId(1).build(),
                SocialMedia.newBuilder().setId(3).setAppName("INSTAGRAM").setUserId(1).build()
        );

        var filteredSocialMedias = socialMedias.stream().filter(socialMedia -> socialMedia.getUserId() == userId).collect(Collectors.toList());
        return filteredSocialMedias;
    }
}
