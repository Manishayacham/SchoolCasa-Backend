package com.schoolcasa.controller;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.service.ApartmentListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
public class ApartmentListingController {
    @Autowired
    private ApartmentListingService apartmentListingService;

    @PostMapping("/postAptLisiting")
    public String addAparmentListing(@RequestParam int bedrooms,
                                     @RequestParam String bathrooms,
                                     @RequestParam double rent,
                                     @RequestParam String address,
                                     @RequestParam String description,
                                     @RequestParam boolean isParkingAvailable,
                                     @RequestParam Date availableDate,
                                     @RequestParam(required = false) MultipartFile image1,
                                     @RequestParam(required = false) MultipartFile image2,
                                     @RequestParam(required = false) MultipartFile image3,
                                     @RequestParam(required = false) String latitude,
                                     @RequestParam(required = false) String longitude) {
        try {
            ApartmentListing apartmentListing = apartmentListingService.addApartmentListing(bedrooms, bathrooms, rent,
                    address, description, isParkingAvailable, availableDate, image1, image2, image3, latitude, longitude);
            if (apartmentListing != null) {
                return "Apartment listing added successful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Apartment listing add failed";
    }
}
