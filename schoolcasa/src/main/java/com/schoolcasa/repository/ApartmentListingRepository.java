package com.schoolcasa.repository;

import com.schoolcasa.model.ApartmentListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentListingRepository extends JpaRepository<ApartmentListing, Integer> {
}
