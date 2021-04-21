package com.schoolcasa.service;

import java.util.List;
import com.schoolcasa.model.ItemListing;

public interface ItemListService {

    public List<ItemListing> getItems();

    public List<ItemListing> getMyItemListings(String email);
}
