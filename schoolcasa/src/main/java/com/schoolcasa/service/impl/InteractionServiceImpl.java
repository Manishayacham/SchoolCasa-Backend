package com.schoolcasa.service.impl;

import com.schoolcasa.model.Interaction;
import com.schoolcasa.model.User;
import com.schoolcasa.repository.InteractionsRepository;
import com.schoolcasa.repository.UserRepository;
import com.schoolcasa.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionsRepository interactionsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    InteractionServiceImpl(InteractionsRepository interactionsRepository) {
        this.interactionsRepository = interactionsRepository;
    }

    @Override
    public void postInteraction(String userEmail, int apartmentId) {
        Date date = new Date();
        User user = userRepository.getUserByEmail(userEmail);
        if (user != null) {
            int userId = user.getId();
            Interaction interaction = new Interaction();
            interaction.setApartmentId(apartmentId);
            interaction.setUserId(userId);
            interaction.setTimestamp(date);
            interactionsRepository.save(interaction);
        }
    }

}
