package com.schoolcasa.controller;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.service.ApartmentListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ApartmentListingController {
    @Autowired
    private ApartmentListingService apartmentListingService;

    @PostMapping("/postAptLisiting")
    public String addAparmentListing(@RequestParam int bedrooms, @RequestParam String bathrooms, @RequestParam double rent, @RequestParam String address, @RequestParam String description, @RequestParam boolean isParkingAvailable) {
        try {
            ApartmentListing apartmentListing = apartmentListingService.addApartmentListing(bedrooms, bathrooms, rent, address, description, isParkingAvailable);
            if (apartmentListing != null) {
                return "Apartment listing added successful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Apartment listing add failed";

    }
}
