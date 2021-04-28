package com.schoolcasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolcasa.model.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages,Integer>{
	
	@Query(value="select * from messages where reciever = ?1",nativeQuery = true)
    public List<Messages> getInboxMessages(String emailID);
	
	@Query(value="select * from messages where sender = ?1",nativeQuery = true)
    public List<Messages> getOutboxMessages(String emailID);


}
