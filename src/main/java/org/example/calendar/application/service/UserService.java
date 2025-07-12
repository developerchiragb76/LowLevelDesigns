package org.example.calendar.application.service;

import org.example.calendar.application.model.User;
import org.example.calendar.application.repository.IUserRepository;

import java.util.List;

public class UserService {
    private final IUserRepository userRepository;
    private final EventService eventService;

    public UserService(IUserRepository userRepository, EventService eventService) {
        this.userRepository = userRepository;
        this.eventService = eventService;
    }

    public void createUser(String email) {
        User user = new User(email);
        userRepository.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserByEmail(String emailId) {
        return userRepository.getUserByEmail(emailId);
    }

}
