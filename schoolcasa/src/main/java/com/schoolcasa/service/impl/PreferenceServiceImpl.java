package com.schoolcasa.service.impl;


import com.schoolcasa.model.Preferences;
import com.schoolcasa.repository.PreferenceRepository;
import com.schoolcasa.service.PreferenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PreferenceServiceImpl implements PreferenceService {


    private PreferenceRepository prefRepository;

    @Autowired
    PreferenceServiceImpl(PreferenceRepository prefRepository) {
        this.prefRepository = prefRepository;
    }


	@Override
	public Preferences addPreference(String foodPref, String studyTime, String isSmoking, String isPetFriendly,
			String email) {
        Preferences preference = new Preferences();
        preference.setFoodPref(foodPref);
        preference.setPetFriendly(isPetFriendly);
        preference.setSmoking(isSmoking);
        preference.setStudyTime(studyTime);
        preference.setEmail(email);
		return prefRepository.save(preference);
	}


}
