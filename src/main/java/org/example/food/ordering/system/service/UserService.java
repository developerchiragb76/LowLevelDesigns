package org.example.food.ordering.system.service;

import org.example.food.ordering.system.model.User;
import org.example.food.ordering.system.repository.IUserRepository;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String userId) {
        return userRepository.getUserById(userId);
    }
}
