package com.schoolcasa.app.service.impl;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.repository.ApartmentListingRepository;
import com.schoolcasa.service.impl.ApartmentListingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentListingServiceTest {
    @MockBean
    ApartmentListingRepository apartmentListingRepository;

    @Autowired
    ApartmentListingServiceImpl apartmentListingService;

    @Test
    public void addApartmentListingTest(){
        ApartmentListing apartmentListing = createApartment();
        given(apartmentListingRepository.save(any())).willReturn(apartmentListing);
        assertEquals(apartmentListing,apartmentListingService.addApartmentListing(1,"1.5",245.0,
                "1 Washington Sq, San Jose","Walkable distance", true,new Date(),null,
                null,null,"37.3257273","-121.87636250000001","xyz@sjsu.edu"));
    }

    private ApartmentListing createApartment(){
        ApartmentListing aptListing = new ApartmentListing();
        aptListing.setId(1);
        aptListing.setBathrooms("1.5");
        aptListing.setBedrooms(1);
        aptListing.setRent(245.0);
        aptListing.setDescription("Walkable distance");
        aptListing.setAvailableDate(new Date());
        aptListing.setParkingAvailable(true);
        aptListing.setLatitude("37.3257273");
        aptListing.setLongitude("-121.87636250000001");
        aptListing.setAddress("1 Washington Sq, San Jose");
        aptListing.setEmail("xyz@sjsu.edu");
        return aptListing;
    }

    @Test
    public void deleteApartmentListingTest(){
        assertEquals(apartmentListingService.deleteApartmentListing(1),"Deletion successful");
    }

    @Test
    public void editApartmentListingTest(){
        ApartmentListing apartmentListing = createApartment();
        given(apartmentListingRepository.save(any())).willReturn(apartmentListing);
        given(apartmentListingRepository.getApartmentById(1)).willReturn(apartmentListing);
        assertEquals(apartmentListing,apartmentListingService.editApartmentListing(1,1,"1.5",245.0,
                "1 Washington Sq, San Jose","Walkable distance", true,new Date(),
                "37.3257273","-121.87636250000001","xyz@sjsu.edu"));
    }
}
