package com.schoolcasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.repository.ApartmentListingRepository;
import com.schoolcasa.service.ShowApartmentListingService;


@Service
public class ShowApartmentListingServiceImpl implements ShowApartmentListingService {
	
	@Autowired
	private ApartmentListingRepository apartmentListingRepository; 

	@Override
	public List<ApartmentListing> getApartments() {
		// TODO Auto-generated method stub
		return apartmentListingRepository.findAll();
	}

	@Override
	public List<ApartmentListing> getMyApartmentListings(String emailID) {
		return apartmentListingRepository.getApartmentListByEmail(emailID);
	}

}
