package org.example.notification.system.repository;

import org.example.notification.system.exceptions.UserNotFoundException;
import org.example.notification.system.models.User;


import java.util.List;

public interface IUserRepository {
    void saveUser(User user);
    User getUserById(String userId) throws UserNotFoundException;
    List<User> getAllUsers();
}
