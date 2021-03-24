package com.schoolcasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.schoolcasa.model.User;
import com.schoolcasa.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 
	@PostMapping("/postUser")
    public String saveUser(@RequestParam String email,
                                     @RequestParam String phoneNum) {
		
        try {
            User user = userService.saveUserDetails(email, phoneNum);
            if (user != null) {
                return "User save successful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "User save failed";
    }

}
