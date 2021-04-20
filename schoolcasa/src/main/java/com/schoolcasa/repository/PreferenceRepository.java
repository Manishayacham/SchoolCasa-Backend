package com.schoolcasa.repository;

import com.schoolcasa.model.Preferences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preferences, Integer> {
    @Query(value="select * from preferences where email = ?1",nativeQuery = true)
    public Preferences getPreferencesByEmail(String emailID);

}
