package com.wolffsoft.bookkeeping.service;

import com.wolffsoft.bookkeeping.model.User;
import com.wolffsoft.bookkeeping.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getById(Integer id) {
        return userRepository.getById(id);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}
