package com.chatmate.chatmatechats.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;

public class LoginControllerTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(LoginController.class).build();

    }

    @Test
    public void getProductsList() throws Exception {
        String uri = "/login";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).param("username","Mustakim")
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        final String usernameCookie = mvcResult.getResponse().getCookie("username").getValue();
        assertEquals(200, status);
        assertEquals("Mustakim",usernameCookie);
        String content = mvcResult.getResponse().getContentAsString();
    }
}