package org.example.splitwise.repository;

import org.example.splitwise.exceptions.UserNotFoundException;
import org.example.splitwise.models.User;

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
    public User getUserById(String userId) throws UserNotFoundException {
        User user = userMap.get(userId);
        if(user == null) throw new UserNotFoundException(userId);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void saveUser(User user) {
        userMap.put(user.getUserId(), user);
    }
}
