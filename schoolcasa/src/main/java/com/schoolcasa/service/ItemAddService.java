package com.schoolcasa.service;

import com.schoolcasa.model.ItemListing;

public interface ItemAddService {

    public ItemListing addItem(String productName,  double price, String address, String description, String category,String age, String warranty , String imageurl);
}
