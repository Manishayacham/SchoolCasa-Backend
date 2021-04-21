package com.schoolcasa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolcasa.model.User;
import com.schoolcasa.repository.UserRepository;
import com.schoolcasa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUserDetails(String email, String phoneNum) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(email);
		user.setPhoneNumber(phoneNum);
		return userRepository.save(user);
	} 
	
	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.getUserByEmail(email);
		
	} 
	
	

}
