package com.schoolcasa.app.service.impl;

import com.schoolcasa.model.Preferences;
import com.schoolcasa.repository.PreferenceRepository;
import com.schoolcasa.service.impl.PreferenceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreferenceServiceTest {
    @MockBean
    PreferenceRepository preferenceRepository;

    @Autowired
    PreferenceServiceImpl preferenceService;

    @Test
    public void addPreferenceTest() {
        Preferences preferences = new Preferences();
        given(preferenceRepository.save(any())).willReturn(preferences);
        assertEquals(preferenceService.addPreference("veg", "late study",
                "no", "no", "xyz@sjsu.edu"), preferences);
    }

    @Test
    public  void editPreferenceTest(){
        Optional<Preferences> preferencesOptional = Optional.of(new Preferences());
        given(preferenceRepository.findById(1)).willReturn(preferencesOptional);
        Preferences preferences = new Preferences();
        given(preferenceRepository.save(any())).willReturn(preferences);
        assertEquals(preferenceService.editPreference(1,"veg", "late study",
                "no", "no", "xyz@sjsu.edu"), preferences);
    }
}
