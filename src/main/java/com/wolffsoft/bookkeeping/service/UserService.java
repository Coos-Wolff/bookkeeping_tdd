package com.wolffsoft.bookkeeping.service;

import com.wolffsoft.bookkeeping.model.User;
import com.wolffsoft.bookkeeping.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }
}
