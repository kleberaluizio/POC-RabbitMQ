package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.respositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel saveUser(UserModel model) {
        return this.userRepository.save(model);
    }
}
