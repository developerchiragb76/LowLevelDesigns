package org.example.food.ordering.system.repository;

import org.example.food.ordering.system.model.User;

import java.util.List;

public interface IUserRepository {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserById(String userId);
}
