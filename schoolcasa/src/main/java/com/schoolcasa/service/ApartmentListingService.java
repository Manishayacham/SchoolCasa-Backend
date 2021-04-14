package com.schoolcasa.service;

import com.schoolcasa.model.ApartmentListing;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public interface ApartmentListingService {
    public ApartmentListing addApartmentListing(int bedrooms, String bathrooms, double rent,
                                                String address, String description, boolean isParkingAvailable,
                                                Date availableDate,
                                                MultipartFile image1,
                                                MultipartFile image2,
                                                MultipartFile image3,
                                                String latitude,
                                                String longitude,
                                                String email);

    public String deleteApartmentListing(int id);

    public ApartmentListing editApartmentListing(int apartmentId,
                                                 int bedrooms,
                                                 String bathrooms,
                                                 double rent,
                                                 String address,
                                                 String description,
                                                 boolean isParkingAvailable,
                                                 Date availableDate,
                                                 String latitude,
                                                 String longitude,
                                                 String email);
}
