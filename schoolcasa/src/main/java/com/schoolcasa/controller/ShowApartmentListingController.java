package com.schoolcasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.service.impl.ShowApartmentListingServiceImpl;


@RestController
@CrossOrigin(origins = "*")
public class ShowApartmentListingController {

    @Autowired
    private ShowApartmentListingServiceImpl showApartmentListingService;

    @GetMapping(path = "/showApartmentListing")
    public List<ApartmentListing> listOfFiles() {
        return showApartmentListingService.getApartments();
    }

    @GetMapping(path = "/getMyApartmentListings/{emailID}")
    public List<ApartmentListing> myApartmentListings(@PathVariable String emailID) {
        return showApartmentListingService.getMyApartmentListings(emailID);
    }
}
