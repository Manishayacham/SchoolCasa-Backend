package com.schoolcasa.service;

import java.util.List;

import com.schoolcasa.model.ApartmentListing;

public interface ShowApartmentListingService {

    public List<ApartmentListing> getApartments();

    public List<ApartmentListing> getMyApartmentListings(String emailID);

}
