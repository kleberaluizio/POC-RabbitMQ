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
    public UserModel saveUser(UserModel model) {
        var userModel = this.userRepository.save(model);
        userProducer.publishMessageEmail(model);
        return userModel;
    }
}
