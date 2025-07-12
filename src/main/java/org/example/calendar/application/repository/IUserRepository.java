package org.example.calendar.application.repository;

import org.example.calendar.application.model.User;

import java.util.List;

public interface IUserRepository {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserByEmail(String email);

}
