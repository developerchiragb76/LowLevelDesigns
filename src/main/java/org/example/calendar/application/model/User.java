package org.example.calendar.application.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userEmail;

    public User(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
