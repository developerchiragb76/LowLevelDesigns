package org.example.notification.system.repository;

import org.example.notification.system.exceptions.UserNotFoundException;
import org.example.notification.system.models.User;


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
        userMap.put(user.getUserId(), user);
    }

    @Override
    public User getUserById(String userId) throws UserNotFoundException {
        if(userId == null)
            throw new NullPointerException("UserId Cannot Be Null");
        User user = userMap.get(userId);
        if(user == null)
            throw new UserNotFoundException(userId);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
