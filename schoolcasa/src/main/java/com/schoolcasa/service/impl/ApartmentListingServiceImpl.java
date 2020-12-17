package com.schoolcasa.service.impl;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.repository.ApartmentListingRepository;
import com.schoolcasa.service.ApartmentListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentListingServiceImpl implements ApartmentListingService {
    private ApartmentListingRepository apartmentListingRepository;

    @Autowired
    ApartmentListingServiceImpl(ApartmentListingRepository apartmentListingRepository) {
        this.apartmentListingRepository = apartmentListingRepository;
    }

    @Override
    public ApartmentListing addApartmentListing(int bedrooms, int bathrooms, double rent, String address, String description, boolean isParkingAvailable) {
        ApartmentListing apartmentListing = new ApartmentListing();
        apartmentListing.setBedrooms(bedrooms);
        apartmentListing.setBathrooms(bathrooms);
        apartmentListing.setRent(rent);
        apartmentListing.setAddress(address);
        apartmentListing.setDescription(description);
        apartmentListing.setParkingAvailable(isParkingAvailable);
        return apartmentListingRepository.save(apartmentListing);
    }
}
