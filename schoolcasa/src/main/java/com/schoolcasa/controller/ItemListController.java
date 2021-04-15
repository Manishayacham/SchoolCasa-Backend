package com.schoolcasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.schoolcasa.model.ItemListing;
import com.schoolcasa.service.impl.ItemListingServiceImpl;


@RestController
@CrossOrigin(origins = "*")
public class ItemListController {
	
	@Autowired
    private ItemListingServiceImpl itemListingService;
	
	@GetMapping(path = "/itemListing")
    public List<ItemListing> listOfItems()  {
		
			return itemListingService.getItems();
    }

    @GetMapping(path="/getMyItemListings/{email}")
    public List<ItemListing> myItemListings(@PathVariable String email){
	    return itemListingService.getMyItemListings(email);
    }

}
