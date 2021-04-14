package com.schoolcasa.service;

import com.schoolcasa.model.ItemListing;
import org.springframework.web.multipart.MultipartFile;

public interface ItemAddService {

    public ItemListing addItem(MultipartFile file,String productName, double price, String address, String description, String category, String age, String warranty, String email);
}
