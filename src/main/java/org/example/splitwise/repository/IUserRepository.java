package org.example.splitwise.repository;

import org.example.splitwise.exceptions.UserNotFoundException;
import org.example.splitwise.models.User;

import java.util.List;

public interface IUserRepository {
    User getUserById(String userId) throws UserNotFoundException;
    List<User> getAllUsers();
    void saveUser(User user);
}
