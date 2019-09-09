package com.chatmate.login.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoginControllerTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(LoginController.class).build();

    }

    @Test
    public void shouldLoginTheUserAndSetItsUsernameAsCookie() throws Exception {
        String uri = "/login";
        mvc.perform(MockMvcRequestBuilders.get(uri).param("username","Mustakim")
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().is(200))
            .andExpect(cookie().value("username","Mustakim"))
            .andReturn();
    }
}