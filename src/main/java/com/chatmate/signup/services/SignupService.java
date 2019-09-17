package com.chatmate.signup.services;

import com.chatmate.signup.models.UserEntity;
import com.chatmate.signup.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class SignupService {

    private UserRepository userRepository;

    public boolean saveUser(UserEntity userEntity) {
        final Optional<UserEntity> optionalUserEntity = userRepository.findById(userEntity.getUsername());
        if (optionalUserEntity.isPresent()) {
            return false;
        }
        userRepository.save(userEntity);
        return true;
    }
}
