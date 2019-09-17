package com.chatmate.signup.services;

import com.chatmate.signup.models.UserEntity;
import com.chatmate.signup.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SignupServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private SignupService signupService;

    @Test
    public void shouldSaveTheUserEntityIntoTheUserRepositoryIfItIsNotAlreadyPresent() {

        final UserEntity userEntity = new UserEntity("username", "name", "password");

        when(userRepository.findById(userEntity.getUsername())).thenReturn(Optional.empty());
        final boolean savedSucessfully = signupService.saveUser(userEntity);

        verify(userRepository).save(userEntity);
        assertThat(savedSucessfully).isTrue();
    }

    @Test
    public void shouldNotSaveUserIfAlreadyPresent() {

        final UserEntity userEntityAlreadyPresent = new UserEntity("username", "name1", "password1");
        final UserEntity userEntityTryingToSave = new UserEntity("username", "name2", "password2");

        when(userRepository.findById(userEntityTryingToSave.getUsername())).thenReturn(Optional.of(userEntityAlreadyPresent));
        boolean savedSucessfully = signupService.saveUser(userEntityTryingToSave);

        verify(userRepository, times(0)).save(userEntityTryingToSave);
        assertThat(savedSucessfully).isFalse();
    }
}