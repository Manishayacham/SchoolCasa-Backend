package com.schoolcasa.service;

import com.schoolcasa.model.ApartmentListing;

import java.util.List;

public interface GetRecommendationsService {

    public List<ApartmentListing> getRecs(String email);
}

