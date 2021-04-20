package com.schoolcasa.controller;

import com.schoolcasa.model.Preferences;
import com.schoolcasa.service.PreferenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PreferencesController {

    @Autowired
    private PreferenceService preferenceService;

    @PostMapping("/addPreference")
    public String addPreference(@RequestParam String foodPref, @RequestParam String studyTime,@RequestParam String isSmoking,@RequestParam String isPetFriendly,
                          @RequestParam String email) {
        try {
            Preferences preference = preferenceService.addPreference( foodPref, studyTime, isSmoking, isPetFriendly, email);
            if (preference != null) {
                return "Preferences added successfully";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Preference add failed";
    }

}