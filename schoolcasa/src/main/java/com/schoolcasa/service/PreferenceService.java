package com.schoolcasa.service;

import com.schoolcasa.model.Preferences;

public interface PreferenceService {

    public Preferences addPreference(String foodPref, String studyTime, String isSmoking, String isPetFriendly, String email);

    public Preferences editPreference(int id, String foodPref, String studyTime, String isSmoking, String isPetFriendly, String email);
    
}
