package com.schoolcasa.service;

import java.util.List;

import com.schoolcasa.model.Messages;


public interface MessagesService {
	public void postMessage(String sender, int aptId, String reciever, String subject, String message);
	public List<Messages> getInboxMessages(String emailID);
	public List<Messages> getOutMessages(String emailID);
}
