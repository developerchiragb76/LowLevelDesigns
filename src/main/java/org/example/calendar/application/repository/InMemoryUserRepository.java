package org.example.calendar.application.repository;

import org.example.calendar.application.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements IUserRepository {
    private final Map<String, User> userMap;

    public InMemoryUserRepository() {
        userMap = new HashMap<>();
    }

    @Override
    public void saveUser(User user) {
        userMap.putIfAbsent(user.getUserEmail(), user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserByEmail(String email) {
        return userMap.getOrDefault(email, null);
    }

}
