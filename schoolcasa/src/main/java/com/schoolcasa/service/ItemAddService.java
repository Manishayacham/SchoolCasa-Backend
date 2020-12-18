package com.schoolcasa.service;

import com.schoolcasa.model.ItemListing;

public interface ItemAddService {

    public ItemListing addItem(String product_name,  double price, String address, String description, String category,double age, double warranty , String imageurl);
}
