package com.schoolcasa.service.impl;

import com.schoolcasa.model.ItemListing;
import com.schoolcasa.repository.ItemRepository;
import com.schoolcasa.service.ItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemAddServiceImpl implements ItemAddService {

    private ItemRepository itemRepository;
    @Autowired
    ItemAddServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemListing addItem(String productName,  double price, String address, String description, String category,String age, String warranty , String imageurl) {
        ItemListing itemListing = new ItemListing();
        itemListing.setProductName(productName);
        itemListing.setAge(age);
        itemListing.setPrice(price);
        itemListing.setAddress(address);
        itemListing.setDescription(description);
        itemListing.setImageURL(imageurl);
        itemListing.setWarranty(warranty);
        itemListing.setCategory(category);

        return itemRepository.save(itemListing);
    }
}
