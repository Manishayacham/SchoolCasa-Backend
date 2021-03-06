package com.schoolcasa.controller;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.service.GetRecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GetRecommendationsController {

    @Autowired
    private GetRecommendationsService getRecommendationsService;

    @GetMapping(path = "/getRecommendations/{email}")
    public List<ApartmentListing> getRecommendations(@PathVariable String email){
        return getRecommendationsService.getRecs(email);
    }
}
