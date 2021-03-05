package com.schoolcasa.service;

import com.schoolcasa.model.ApartmentListing;

import java.util.Date;

public interface ApartmentListingService {
    public ApartmentListing addApartmentListing(int bedrooms, String bathrooms, double rent, String address, String description, boolean isParkingAvailable, Date availableDate);
}
