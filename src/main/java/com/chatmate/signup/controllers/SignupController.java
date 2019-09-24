package com.chatmate.signup.controllers;


import com.chatmate.signup.models.SignupResponseViewModel;
import com.chatmate.signup.models.UserEntity;
import com.chatmate.signup.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    SignupService signupService;

    @PostMapping("/signup")
    public SignupResponseViewModel signup(
        @RequestBody UserEntity userEntity
    ) {
        System.out.println("is it coming here");
        return signupService.saveUser(userEntity);
    }

}
