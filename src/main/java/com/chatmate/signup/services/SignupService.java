package com.chatmate.signup.services;

import com.chatmate.signup.models.SignupResponseViewModel;
import com.chatmate.signup.models.UserEntity;
import com.chatmate.signup.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class SignupService {

    private UserRepository userRepository;

    public SignupResponseViewModel saveUser(UserEntity userEntity) {
        final Optional<UserEntity> optionalUserEntity = userRepository.findById(userEntity.getUsername());
        if (optionalUserEntity.isPresent()) {
            return new SignupResponseViewModel(false,"Username already exists");
        }
        userRepository.save(userEntity);
        return new SignupResponseViewModel(true,null);
    }
}
