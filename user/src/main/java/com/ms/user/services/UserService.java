package com.ms.user.services;

import com.ms.user.definition.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.respositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;

    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel saveUser(UserModel userModel) {
        userModel = this.userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
