package com.schoolcasa.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolcasa.model.ItemListing;
import com.schoolcasa.repository.ItemRepository;
import com.schoolcasa.service.ItemListService;



@Service
public class ItemListingServiceImpl implements ItemListService {
	
	@Autowired
	private ItemRepository itemListingRepository; 

	@Override
	public List<ItemListing> getItems() {
		// TODO Auto-generated method stub
		return itemListingRepository.findAll();
	}

}