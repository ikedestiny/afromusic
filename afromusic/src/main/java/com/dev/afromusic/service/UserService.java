package com.dev.afromusic.service;

import com.dev.afromusic.models.Registration;
import com.dev.afromusic.models.UserEntity;
import org.springframework.stereotype.Service;

public interface UserService {
     UserEntity findByEmail(String email);

    void saveUser(Registration registration);

    UserEntity findByUsername(String username);
}
