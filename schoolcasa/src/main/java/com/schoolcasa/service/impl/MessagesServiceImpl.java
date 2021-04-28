package com.schoolcasa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolcasa.model.Messages;
import com.schoolcasa.repository.MessagesRepository;
import com.schoolcasa.repository.UserRepository;
import com.schoolcasa.service.MessagesService;

@Service
public class MessagesServiceImpl implements MessagesService{
	
	@Autowired
	private MessagesRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void postMessage(String sender, int aptId, String reciever, String subject, String message) {
		
		Date date = new Date();
		Messages message1 = new Messages();
		
		
		message1.setApartmentId(aptId);
		message1.setReciever(reciever);
		message1.setSender(sender);
		message1.setSubject(subject);
		message1.setMessage(message);
		message1.setTimestamp(date);
		message1.setUserId(userRepository.getUserByEmail(reciever).getId());
		messageRepository.save(message1);	
		
	}

	@Override
	public List<Messages> getInboxMessages(String emailID) {
		return messageRepository.getInboxMessages(emailID);
	}

	@Override
	public List<Messages> getOutMessages(String emailID) {
		return messageRepository.getOutboxMessages(emailID);
	}
	

}
