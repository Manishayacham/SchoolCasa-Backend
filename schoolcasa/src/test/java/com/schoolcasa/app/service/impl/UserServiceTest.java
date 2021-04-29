package com.schoolcasa.app.service.impl;

import com.schoolcasa.model.User;
import com.schoolcasa.repository.UserRepository;
import com.schoolcasa.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void saveUserDetailsTest(){
        User user = new User();
        given(userRepository.save(any())).willReturn(user);
        assertEquals(userService.saveUserDetails("xyz@sjsu.edu","+1650345245"),user);
    }

    @Test
    public void getUserByEmailTest(){
        User user = new User();
        given(userRepository.getUserByEmail("xyz@sjsu.edu")).willReturn(user);
        assertEquals(userService.getUserByEmail("xyz@sjsu.edu"),user);
    }
}
