package com.schoolcasa.repository;


import com.schoolcasa.model.ItemListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemListing, Integer> {

    @Query(value = "select * from item_listing where email=?1", nativeQuery = true)
    public List<ItemListing> getItemListByEmail(String email);
}
