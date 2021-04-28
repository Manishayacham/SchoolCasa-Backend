package com.schoolcasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolcasa.model.Messages;
import com.schoolcasa.service.MessagesService;

@RestController
@CrossOrigin(origins = "*")
public class MessagesController {
	
	@Autowired
	private MessagesService messagesService;
	
	@PostMapping("/postMessage")
	private void postMessage(@RequestParam String sender, @RequestParam int aptId, @RequestParam String reciever, @RequestParam String subject, @RequestParam String message) {
		messagesService.postMessage(sender, aptId, reciever, subject, message);
	}
	
	@GetMapping(path = "/getInboxMessages/{emailID}")
    public List<Messages> getInboxMessages(@PathVariable String emailID) {
		return messagesService.getInboxMessages(emailID);
    }
	@GetMapping(path = "/getOutboxMessages/{emailID}")
    public List<Messages> getOutboxMessages(@PathVariable String emailID) {
        return messagesService.getOutMessages(emailID);
    }

}
