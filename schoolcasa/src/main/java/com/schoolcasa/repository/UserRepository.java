package com.schoolcasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.schoolcasa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where email=?1", nativeQuery = true)
    public User getUserByEmail(String email);
}
