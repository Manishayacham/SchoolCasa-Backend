package com.schoolcasa.repository;

import com.schoolcasa.model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractionsRepository extends JpaRepository<Interaction,Integer> {

}
