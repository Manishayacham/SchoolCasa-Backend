package com.schoolcasa.app.service.impl;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.repository.ApartmentListingRepository;
import com.schoolcasa.service.impl.ShowApartmentListingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowApartmentListingServiceTest {
    @MockBean
    private ApartmentListingRepository apartmentListingRepository;

    @Autowired
    private ShowApartmentListingServiceImpl showApartmentListingService;

    @Test
    public void getApartmentsTest(){
        ApartmentListing aptListing1 = createApartment(1,"xyz@sjsu.edu" );
        ApartmentListing aptListing2 = createApartment(2,"abc@sjsu.edu");
        List<ApartmentListing> list = new ArrayList<>();
        list.add(aptListing1);
        list.add(aptListing2);
        given(apartmentListingRepository.findAll()).willReturn(list);
        List<ApartmentListing> apartmentListings = showApartmentListingService.getApartments();
        assertEquals(apartmentListings.size(), list.size());
    }


    @Test
    public void getMyApartmentsTest(){
        ApartmentListing aptListing1 = createApartment(1,"xyz@sjsu.edu" );
        ApartmentListing aptListing2 = createApartment(2,"xyz@sjsu.edu");
        List<ApartmentListing> list = new ArrayList<>();
        list.add(aptListing1);
        list.add(aptListing2);
        given(apartmentListingRepository.getApartmentListByEmail("xyz@sjsu.edu")).willReturn(list);
        List<ApartmentListing> apartmentListings = showApartmentListingService.getMyApartmentListings("xyz@sjsu.edu");
        assertEquals(apartmentListings.size(), list.size());
    }

    private ApartmentListing createApartment(int id, String email){
        ApartmentListing aptListing = new ApartmentListing();
        aptListing.setId(id);
        aptListing.setAddress("1 Washington Drive, San Jose");
        aptListing.setEmail(email);
        return aptListing;
    }
}
