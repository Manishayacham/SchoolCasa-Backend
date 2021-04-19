package com.schoolcasa.controller;

import com.schoolcasa.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    @PostMapping("/postInteraction")
    private void postInteraction(@RequestParam String userEmail, @RequestParam int apartmentId){
        interactionService.postInteraction(userEmail,apartmentId);
    }
}
