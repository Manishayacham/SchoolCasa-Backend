package com.schoolcasa.controller;

import com.schoolcasa.model.ItemListing;
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
    public String addPreference(@RequestBody Preferences preferenceObject) {
        try {
            Preferences preference = preferenceService.addPreference( preferenceObject.getFoodPref(), preferenceObject.getIsStudyTime(), preferenceObject.getIsSmoking(), preferenceObject.getIsPetFriendly(), preferenceObject.getEmail());
            if (preference != null) {
                return "Preferences added successfully";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Preference add failed";
    }
    
    @PutMapping("/editPreferences")
    public String editPreference(@RequestParam int id, @RequestParam String foodPref, @RequestParam String studyTime,@RequestParam String isSmoking,@RequestParam String isPetFriendly,
            @RequestParam String email) {
    	System.out.println("editing");
    	try {
            Preferences preference = preferenceService.editPreference(id, foodPref, studyTime, isSmoking, isPetFriendly, email);
            if (preference != null) {
                return "Preferences edit successful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Preferences edit failed";
    }
    

}
