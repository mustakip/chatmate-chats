package com.chatmate.login.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
public class LoginController {

    @RequestMapping("/")
    public String home() {
        return "This is home";
    }

    @RequestMapping("/login")
    public void login(HttpServletResponse response, @RequestParam("username") String username) {
        response.addCookie(new Cookie("username", username));
    }

}
