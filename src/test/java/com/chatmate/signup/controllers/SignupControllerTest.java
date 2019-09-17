package com.chatmate.signup.controllers;

import com.chatmate.signup.models.UserEntity;
import com.chatmate.signup.services.SignupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SignupControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private SignupController signupController;

    @Mock
    private SignupService signupService;


    @Test
    public void shouldReturnTrueIfUserSignupIsSucessful() throws Exception {
        final UserEntity userEntity = new UserEntity("username", "name", "password");
        when(signupService.saveUser(userEntity)).thenReturn(true);

        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(signupController).build();


        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content("{\"username\": \"username\", \"name\": \"name\", \"password\": \"password\"}"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("true"))
            .andReturn();
    }

    @Test
    public void shouldReturnfalseIfUserSignupIsUnSucessful() throws Exception {
        final UserEntity userEntity = new UserEntity("username", "name", "password");
        when(signupService.saveUser(userEntity)).thenReturn(false);

        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(signupController).build();


        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content("{\"username\": \"username\", \"name\": \"name\", \"password\": \"password\"}"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("false"))
            .andReturn();
    }
}