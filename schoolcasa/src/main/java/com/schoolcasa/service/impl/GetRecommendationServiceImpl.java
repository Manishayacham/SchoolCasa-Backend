package com.schoolcasa.service.impl;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.model.User;
import com.schoolcasa.repository.ApartmentListingRepository;
import com.schoolcasa.repository.UserRepository;
import com.schoolcasa.service.GetRecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.personalizeruntime.PersonalizeRuntimeClient;
import software.amazon.awssdk.services.personalizeruntime.model.GetRecommendationsRequest;
import software.amazon.awssdk.services.personalizeruntime.model.GetRecommendationsResponse;
import software.amazon.awssdk.services.personalizeruntime.model.PredictedItem;

import java.util.LinkedList;
import java.util.List;

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

@Service
public class GetRecommendationServiceImpl implements GetRecommendationsService {

    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretKey}")
    private String secretKey;

    @Value("${campaignArn}")
    private String campaignArn;

    @Autowired
    private ApartmentListingRepository apartmentListingRepository;

    @Autowired
    UserRepository userRepo;

    @Override
    public List<ApartmentListing> getRecs(String email){

        List<ApartmentListing> apartmentListings = new LinkedList<>();

        AwsCredentials credentials  = new AwsCredentials() {
            @Override
            public String accessKeyId() {
                return accessKey;
            }

            @Override
            public String secretAccessKey() {
                return secretKey;
            }
        };

        AwsCredentialsProvider awsCredentialsProvider = () -> credentials;

        Region region = Region.US_WEST_2;

        PersonalizeRuntimeClient personalizeRuntimeClient = PersonalizeRuntimeClient.builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(region)
                .build();


        User user = userRepo.getUserByEmail(email);
        int userId = 0;
        if (user != null) {
             userId = user.getId();
        }

        try {
            GetRecommendationsRequest recommendationsRequest = GetRecommendationsRequest.builder()
                    .campaignArn(campaignArn)
                    .numResults(10)
                    .userId(String.valueOf(userId))
                    .build();

            GetRecommendationsResponse recommendationsResponse = personalizeRuntimeClient.getRecommendations(recommendationsRequest);
            List<PredictedItem> items = recommendationsResponse.itemList();

            for (PredictedItem item: items) {
                int aptId = Integer.parseInt(item.itemId());
                ApartmentListing apartmentListing = apartmentListingRepository.getRecommendedApartmentListById(aptId,email);
                if(apartmentListing != null)
                apartmentListings.add(apartmentListing);
            }
        } catch (AwsServiceException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        personalizeRuntimeClient.close();
        return apartmentListings;
    }
}
