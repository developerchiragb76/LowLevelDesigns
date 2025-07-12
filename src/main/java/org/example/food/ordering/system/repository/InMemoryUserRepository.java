package org.example.food.ordering.system.repository;

import org.example.food.ordering.system.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements IUserRepository {
    private final Map<String, User> userMap;

    public InMemoryUserRepository() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void saveUser(User user) {
        userMap.putIfAbsent(user.getUserId(), user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(String userId) {
        return userMap.getOrDefault(userId, null);
    }
}
