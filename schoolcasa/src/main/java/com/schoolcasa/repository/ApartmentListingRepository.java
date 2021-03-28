package com.schoolcasa.repository;

import com.schoolcasa.model.ApartmentListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentListingRepository extends JpaRepository<ApartmentListing, Integer> {
    @Query(value="select * from apartment_listing where email = ?1",nativeQuery = true)
    public List<ApartmentListing> getApartmentListByEmail(String emailID);
}
