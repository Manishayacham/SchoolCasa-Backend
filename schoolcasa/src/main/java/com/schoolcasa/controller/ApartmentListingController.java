package com.schoolcasa.controller;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.service.ApartmentListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
                                     @RequestParam(required = false) String longitude,
                                     @RequestParam String email) {
        try {
            ApartmentListing apartmentListing = apartmentListingService.addApartmentListing(bedrooms, bathrooms, rent,
                    address, description, isParkingAvailable, availableDate, image1, image2, image3, latitude, longitude, email);
            if (apartmentListing != null) {
                return "Apartment listing added successful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Apartment listing add failed";
    }

    @DeleteMapping("/deleteApartmentListing/{id}")
    public String deleteApartmentListing(@PathVariable int id) {
        return apartmentListingService.deleteApartmentListing(id);
    }

    @PutMapping("/editApartmentListing")
    public String editAparmentListing(@RequestParam int apartmentId,
                                      @RequestParam int bedrooms,
                                      @RequestParam String bathrooms,
                                      @RequestParam double rent,
                                      @RequestParam String address,
                                      @RequestParam String description,
                                      @RequestParam boolean isParkingAvailable,
                                      @RequestParam Date availableDate,
                                      @RequestParam(required = false) String latitude,
                                      @RequestParam(required = false) String longitude,
                                      @RequestParam String email) {
        try {
            ApartmentListing apartmentListing = apartmentListingService.editApartmentListing(apartmentId, bedrooms, bathrooms, rent,
                    address, description, isParkingAvailable, availableDate, latitude, longitude, email);
            if (apartmentListing != null) {
                return "Apartment listing edit successful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Apartment listing edit failed";
    }
}
