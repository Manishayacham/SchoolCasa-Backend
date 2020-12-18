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
    public ItemListing addItem(String product_name,  double price, String address, String description, String category,double age, double warranty , String imageurl) {
        ItemListing itemListing = new ItemListing();
        itemListing.setProduct_name(product_name);
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
